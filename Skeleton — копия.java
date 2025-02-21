package enemies;

public class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 50, 10, 20);
    }

    @Override
    public int attack() {
        // Логика атаки для скелета
        return attackPower;
    }
}
