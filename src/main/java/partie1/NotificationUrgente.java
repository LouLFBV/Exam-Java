package partie1;

// Implémentations concrètes de l'abstraction
class NotificationUrgente extends Notification {
    public NotificationUrgente(CanalEnvoi canal) { super(canal); }

    @Override
    public void notifier(String destinataire, String contenu) {
        canal.envoyer(destinataire, "[URGENT] " + contenu);
    }
}
