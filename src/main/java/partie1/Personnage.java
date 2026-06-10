package partie1;

public class Personnage {
    private final String nom;
    private final String classe;
    private int pv;
    private int mana;
    private String arme;
    private boolean estElite;
    private EtatPersonnage etat; 

    private Personnage(Builder builder) {
        this.nom = builder.nom;
        this.classe = builder.classe;
        this.pv = builder.pv;
        this.mana = builder.mana;
        this.arme = builder.arme;
        this.estElite = builder.estElite;
        this.etat = new EtatVivant(this); // État par défaut
    }

    // MÉTHODES DE DÉLÉGATION (Dans Personnage, pas dans le Builder)
    public String attaquer(String cible) { return etat.attaquer(cible); }
    public String recevoirPoison() { return etat.recevoirPoison(); }
    public String mourir() { return etat.mourir(); }
    
    public void setEtat(EtatPersonnage etat) { this.etat = etat; }
    public String getNom() { return nom; }

    // Builder reste à la fin
    public static class Builder {
        private final String nom;
        private final String classe;
        private int pv = 100;
        private int mana = 50;
        private String arme = "Poings";
        private boolean estElite = false;

        public Builder(String nom, String classe) {
            this.nom = nom;
            this.classe = classe;
        }

        public Builder setPv(int pv) { this.pv = pv; return this; }
        public Builder setMana(int mana) { this.mana = mana; return this; }
        public Builder setArme(String arme) { this.arme = arme; return this; }
        public Builder setEstElite(boolean estElite) { this.estElite = estElite; return this; }

        public Personnage build() {
            if (nom == null || nom.isEmpty() || classe == null || classe.isEmpty()) {
                throw new IllegalArgumentException("Nom et classe obligatoires !");
            }
            return new Personnage(this);
        }
    }
}