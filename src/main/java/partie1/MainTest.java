package partie1;

public class MainTest {
    public static void main(String[] args) {
        // --- A. Singleton ---
        System.out.println("--- Test Singleton ---");
        GameServer server1 = GameServer.getInstance();
        server1.connect();
        GameServer server2 = GameServer.getInstance();
        server2.connect();
        System.out.println("Nombre de joueurs : " + server1.getConnectedPlayers());
        System.out.println("Même instance ? " + (server1 == server2));

        // --- B. Builder ---
        System.out.println("\n--- Test Builder ---");
        Personnage p = new Personnage.Builder("Arthas", "Guerrier")
                .setPv(150)
                .setArme("Deuillegivre")
                .setEstElite(true)
                .build();
        System.out.println(p.toString());

        // --- C. Factory Method ---
        System.out.println("\n--- Test Factory Method ---");
        Forgeron forgeron = new ForgeronEpee();
        System.out.println(forgeron.presenterArme());

        // --- D. Decorator ---
        System.out.println("\n--- Test Decorator ---");
        Potion potion = new AvecMana(new AvecAntidote(new PotionDeBase()));
        System.out.println("Effets : " + potion.getEffets());
        System.out.println("PV totaux : " + potion.getPV());

        // --- E. Bridge ---
        System.out.println("\n--- Test Bridge ---");
        Notification notif = new NotificationUrgente(new CanalEmail());
        notif.notifier("admin@jeu.fr", "Maintenance immédiate.");

        // --- F. State ---
        System.out.println("\n--- Test State ---");
        Personnage hero = new Personnage.Builder("Hero", "Mage").build();
        System.out.println(hero.attaquer("Monstre")); // État Vivant
        System.out.println(hero.recevoirPoison());     // Passe à Empoisonné
        System.out.println(hero.attaquer("Monstre")); // État Empoisonné
        System.out.println(hero.mourir());            // Passe à Mort
        System.out.println(hero.attaquer("Monstre")); // État Mort
    }
}