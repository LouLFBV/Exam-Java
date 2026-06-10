package partie4;

public class ValidateurJeu {
 /** (1 pt) Retourne true si le pseudo est valide :
 * 3 à 16 caractères, lettres, chiffres, tiret bas uniquement. */
 public static boolean pseudoValide(String pseudo) { }
 /** (2 pts) Extrait tous les scores d'un texte de la forme
 * "Alice:1500 points, Bob:320 points"
 * Retourne Map<String, Integer> : pseudo -> score. */
 public static Map<String, Integer> extraireScores(String texte) { }
 /** (1 pt) Remplace les suites de chiffres par "***" dans un texte.
 * Ex: "Code 1234 et pin 5678" → "Code *** et pin ***" */
 public static String masquerNombres(String texte) { }
}