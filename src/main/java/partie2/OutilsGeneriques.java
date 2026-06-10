package partie2;
import java.util.List;
import java.util.NoSuchElementException;

public class OutilsGeneriques {

    
 /** (2 pts) Retourne le max d'une List<T> où T est Comparable.
 * Lève NoSuchElementException si la liste est vide. */
    public static <T extends Comparable<T>> T max(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new NoSuchElementException("La liste est vide ou nulle.");
        }
        
        T max = liste.get(0);
        for (T element : liste) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    
 /** (1 pt) Concatène les éléments d'une List<T> séparés par sep. */
    public static <T> String concat(List<T> liste, String sep) {
        if (liste == null || liste.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < liste.size(); i++) {
            sb.append(liste.get(i).toString());
            if (i < liste.size() - 1) {
                sb.append(sep);
            }
        }
        return sb.toString();
    }
}