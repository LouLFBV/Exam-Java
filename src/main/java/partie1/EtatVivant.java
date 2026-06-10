package partie1;

// État Vivant
class EtatVivant extends EtatPersonnage {
    public EtatVivant(Personnage p) { super(p); }

    @Override
    public String attaquer(String cible) {
        return personnage.getNom() + " attaque " + cible + ".";
    }

    @Override
    public String recevoirPoison() {
        personnage.setEtat(new EtatEmpoisonne(personnage));
        return "Le personnage est maintenant empoisonné.";
    }

    @Override
    public String mourir() {
        personnage.setEtat(new EtatMort(personnage));
        return "Le personnage est mort.";
    }
}

