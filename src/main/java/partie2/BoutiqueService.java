package partie2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoutiqueService {
    private final List<Produit> produits;

    public BoutiqueService(List<Produit> produits) {
        this.produits = produits;
    }

    /** (2 pts) Produits en stock (stock > 0), triés par prix croissant. */
    public List<Produit> getProduitsDisponibles() {
        return produits.stream()
                .filter(p -> p.stock() > 0)
                .sorted(Comparator.comparingDouble(Produit::prix))
                .collect(Collectors.toList());
    }

    /** (2 pts) Prix moyen des produits d'une catégorie donnée. */
    public double getPrixMoyen(String categorie) {
        return produits.stream()
                .filter(p -> p.categorie().equals(categorie))
                .mapToDouble(Produit::prix)
                .average()
                .orElse(0.0);
    }

    /** (3 pts) Map : catégorie -> liste de noms de produits (triés alpha). */
    public Map<String, List<String>> getNomsParCategorie() {
        return produits.stream()
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.mapping(
                                Produit::nom,
                                Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    Collections.sort(list);
                                    return list;
                                })
                        )
                ));
    }

    /** (3 pts) Produits dont le stock est en dessous du seuil, par catégorie. */
    public Map<String, Long> getAlertesRupture(int seuil) {
        return produits.stream()
                .filter(p -> p.stock() < seuil)
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.counting()
                ));
    }

    /** (2 pts) Optional<Produit> : le produit le plus cher. */
    public Optional<Produit> getProduitLePlusCher() {
        return produits.stream()
                .max(Comparator.comparingDouble(Produit::prix));
    }

    /** (2 pts) Valeur totale du stock : somme de (prix * stock). */
    public double getValeurTotaleStock() {
        return produits.stream()
                .mapToDouble(p -> p.prix() * p.stock())
                .sum();
    }
}