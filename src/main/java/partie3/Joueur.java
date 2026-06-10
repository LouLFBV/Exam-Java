package partie3;

@Entite(table = "joueurs")
public class Joueur {

    @Colonne(nom = "pseudo", nullable = false)
    private String pseudo;

    @Colonne(nom = "score")
    private int score;

    private String motDePasseHash;// pas annoté — ne doit pas apparaître

    public Joueur(String pseudo, int score, String motDePasseHash) {
        this.pseudo = pseudo;
        this.score = score;
        this.motDePasseHash = motDePasseHash;
    }

    @Loggable(niveau = "WARN")
    public void resetScore() {
        this.score = 0;
    }

    public String getPseudo() { 
        return pseudo; 
    }

    public int getScore() { 
        return score; 
    }
}