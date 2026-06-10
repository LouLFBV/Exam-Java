package partie1;

// Implémente : ForgeronArc (Arc : 60 dégâts) (2 pts)
public class ForgeronArc extends Forgeron {
 @Override
 public Arme forger() {
 return new Arme() {
 @Override
 public String nom() {
 return "Arc";
 }

 @Override
 public int degats() {
 return 60;
 }
 };
 }
}
