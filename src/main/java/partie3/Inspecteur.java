package partie3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Inspecteur {
 /** (2 pts) Retourne le nom de la table si @Entite est présent,
 * sinon lève IllegalArgumentException. */
 public static String getNomTable(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entite.class)) {
            throw new IllegalArgumentException("La classe n'est pas annotée avec @Entite");
        }
        Entite entite = clazz.getAnnotation(Entite.class);
        return entite.table();
    }

 /** (3 pts) Retourne les noms des champs annotés @Colonne.
 * Si @Colonne.nom() est vide, utilise le nom du champ Java à la place. */
public static List<String> getColonnes(Class<?> clazz) {
        List<String> nomsColonnes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                Colonne colonne = field.getAnnotation(Colonne.class);
                // Si nom() est vide, on utilise le nom du champ Java
                String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                nomsColonnes.add(nom);
            }
        }
        return nomsColonnes;
    }

 /** (2 pts) Retourne les noms des champs @Colonne où nullable = false. */
public static List<String> getColonnesObligatoires(Class<?> clazz) {
        List<String> obligatoires = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                Colonne colonne = field.getAnnotation(Colonne.class);
                if (!colonne.nullable()) {
                    String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                    obligatoires.add(nom);
                }
            }
        }
        return obligatoires;
    }


 /** (3 pts) Retourne les noms des méthodes annotées @Loggable
 * dont le niveau correspond au paramètre donné (ex: "WARN"). */
 public static List<String> getMethodesLoggables(Class<?> clazz, String niveau) {
        List<String> methodes = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable loggable = method.getAnnotation(Loggable.class);
                if (loggable.niveau().equals(niveau)) {
                    methodes.add(method.getName());
                }
            }
        }
        return methodes;
    }
}
