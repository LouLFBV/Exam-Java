package partie2;

import java.util.function.Function;

public class LambdaFactory {

    /** (2 pts) Retourne une Transformation<String> qui met en majuscules
     * et préfixe avec ">> " */
    public static Transformation<String> majusculeEtPrefixe() {
        return (valeur) -> ">> " + valeur.toUpperCase();
    }

    /** (2 pts) Retourne une Transformation<Integer> qui calcule n! (factorielle) */
    public static Transformation<Integer> factorielle() {
        return (n) -> {
            int resultat = 1;
            for (int i = 2; i <= n; i++) {
                resultat *= i;
            }
            return resultat;
        };
    }

    /** (3 pts) Retourne une Function<Integer,Integer> qui retourne
     * le n-ième terme de Fibonacci (F(0)=0, F(1)=1). */
    public static Function<Integer, Integer> fibonacci() {
        return (n) -> {
            if (n <= 1) return n;
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        };
    }
}