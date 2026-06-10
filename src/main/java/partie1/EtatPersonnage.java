package partie1;

// Classe abstraite de base
public abstract class EtatPersonnage {
    protected Personnage personnage;

    public EtatPersonnage(Personnage p) {
        this.personnage = p;
    }

    public abstract String attaquer(String cible);
    public abstract String recevoirPoison();
    public abstract String mourir();
}