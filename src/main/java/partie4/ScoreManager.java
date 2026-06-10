package partie4;

public class ScoreManager {
 /** (2 pts) Écrit la liste dans un fichier CSV. Utilise try-with-resources.
 * Format : une ligne par entrée "pseudo,score\n" */
 public static void sauvegarder(String fichier, List<Paire<String,Integer>>
scores)
 throws IOException { }
 /** (2 pts) Lit le fichier et retourne la liste de paires.
 * Ignore les lignes malformées (pas de crash). */
 public static List<Paire<String,Integer>> charger(String fichier)
 throws IOException { }
}
