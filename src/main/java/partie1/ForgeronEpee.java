package partie1;

// Implémente : ForgeronEpee (Epee : 80 dégâts) (2 pts)
public class ForgeronEpee extends Forgeron {
    @Override
    public Arme forger() {
        return new Arme() {
            @Override
            public String nom() {
                return "Epee";
            }

            @Override
            public int degats() {
                return 80;
            }
        };
    }
}