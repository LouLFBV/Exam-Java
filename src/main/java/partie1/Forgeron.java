package partie1;

public abstract class Forgeron {
 // Méthode factory à implémenter par les sous-classes.
 public abstract Arme forger();
 // Méthode finale : affiche l'arme forgée. (1 pt)
 public final String presenterArme() { 
    return "Voici votre arme : " + forger().nom() + " avec " + forger().degats() + " dégâts.";
  }
}