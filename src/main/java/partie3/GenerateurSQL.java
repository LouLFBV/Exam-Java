package partie3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenerateurSQL {
 /** (4 pts) Génère un SELECT : (4 pts)
 * "SELECT pseudo, score FROM joueurs"
 * Utilise @Entite.table() et les noms de @Colonne.
 * Lève IllegalArgumentException si @Entite absent. */
public static String genererSelect(Class<?> clazz) {
        String nomTable = Inspecteur.getNomTable(clazz);
        List<String> colonnes = Inspecteur.getColonnes(clazz);      
        String colonnesStr = String.join(", ", colonnes);
        return "SELECT " + colonnesStr + " FROM " + nomTable;
    }
 /** (5 pts) Génère un INSERT à partir d'une instance : (5 pts)
 * "INSERT INTO joueurs (pseudo, score) VALUES ('Alice', 1500)"
 * Lis les valeurs par réflexion (field.get(objet)).
 * Les champs non-nullable qui sont null lèvent IllegalStateException. */
 public static String genererInsert(Object objet) throws Exception {
        Class<?> clazz = objet.getClass();
        String nomTable = Inspecteur.getNomTable(clazz);
        
        List<String> nomsColonnes = new ArrayList<>();
        List<String> valeurs = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                field.setAccessible(true); 
                Object valeur = field.get(objet);
                Colonne colonne = field.getAnnotation(Colonne.class);
                
                if (!colonne.nullable() && valeur == null) {
                    throw new IllegalStateException("Le champ " + field.getName() + " ne peut pas être null.");
                }

                String nomCol = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                nomsColonnes.add(nomCol);
                
                if (valeur instanceof String) {
                    valeurs.add("'" + valeur + "'");
                } else {
                    valeurs.add(String.valueOf(valeur));
                }
            }
        }

        return "INSERT INTO " + nomTable + " (" + String.join(", ", nomsColonnes) + ") " +
               "VALUES (" + String.join(", ", valeurs) + ")";
    }
}
