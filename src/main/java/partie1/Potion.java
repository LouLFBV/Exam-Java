package partie1;

public interface Potion {
 int getPV(); // points de vie restaurés
 String getEffets(); // description des effets
}
// Implémente PotionDeBase : 50 PV, effet "Soin de base". 

// Implémente PotionDecorator (abstract) : délègue à la Potion wrappée. (1 pt)
// Implémente AvecAntidote extends PotionDecorator : (2 pts)
// +0 PV, ajoute l'effet "Antidote"
// Implémente AvecMana extends PotionDecorator : (2 pts)
// +30 PV, ajoute l'effet "Restauration de mana"
