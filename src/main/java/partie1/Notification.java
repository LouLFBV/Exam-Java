package partie1;

// 2. Abstraction Bridge
public abstract class Notification {
    protected CanalEnvoi canal;

    public Notification(CanalEnvoi canal) {
        this.canal = canal;
    }

    public abstract void notifier(String destinataire, String contenu);
}
