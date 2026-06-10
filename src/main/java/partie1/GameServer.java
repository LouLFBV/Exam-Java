
package partie1;

public class GameServer {
    private static volatile GameServer instance;

    private final int port;
    private int connectedPlayers = 0;

    private GameServer() {
        this.port = 8080;
    }

    // 1. Implémente le pattern Singleton avec Double-Checked Locking. (3 pts)
    public static GameServer getInstance() {
        if (instance == null) { 
            synchronized (GameServer.class) {
                if (instance == null) { 
                    instance = new GameServer();
                }
            }
        }
        return instance;
    }

    // 2. Méthode connect() : incrémente le nombre de joueurs (1 pt)
    public synchronized void connect() {
        this.connectedPlayers++;
    }

    // 3. Méthode getConnectedPlayers() : retourne le nombre de joueurs (1 pt)
    public int getConnectedPlayers() {
        return connectedPlayers;
    }
}