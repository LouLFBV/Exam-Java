package partie1;

// Ajoute le Mana (+30 PV supplémentaires)
public class AvecMana extends PotionDecorator {
    public AvecMana(Potion potion) { super(potion); }

    @Override
    public int getPV() { 
        return super.getPV() + 30;
    }

    @Override
    public String getEffets() { 
        return super.getEffets() + ", Restauration de mana"; 
    }
}