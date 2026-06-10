package partie1;

// État Mort
class EtatMort extends EtatPersonnage {
    public EtatMort(Personnage p) { 
        super(p);
 }

    @Override
    public String attaquer(String cible) { 
        return "Action impossible, " + personnage.getNom() + " est mort.";
    }
    @Override
    public String recevoirPoison() { 
        return "Action impossible, " + personnage.getNom() + " est mort."; 
}
    @Override
    public String mourir() {
         return "Action impossible, " + personnage.getNom() + " est mort."; 
    }
}