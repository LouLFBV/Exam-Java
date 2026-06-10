package partie2;

public class Paire<A, B> {
    private final A first;
    private final B second;

 // 1. Attributs + constructeur (1 pt)
    public Paire(A first, B second) {
        this.first = first;
        this.second = second;
    }

    // 2. getters getFirst(), getSecond() (1 pt)
    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    // 3. swap() — retourne une Paire<B,A> avec les valeurs inversées (2 pts)
    public Paire<B, A> swap() {
        return new Paire<>(this.second, this.first);
    }

    // 4. toString() (1 pt)
    @Override
    public String toString() {
        return "Paire{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}