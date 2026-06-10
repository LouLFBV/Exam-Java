package partie1;

// État Empoisonné
class EtatEmpoisonne extends EtatPersonnage {
    public EtatEmpoisonne(Personnage p) { super(p); }

    @Override
    public String attaquer(String cible) {
        return personnage.getNom() + " attaque " + cible + ". " + personnage.getNom() + " perd 10 PV (poison).";
    }

    @Override
    public String recevoirPoison() {
        return "Déjà empoisonné.";
    }

    @Override
    public String mourir() {
        personnage.setEtat(new EtatMort(personnage));
        return "Le personnage est mort.";
    }
}