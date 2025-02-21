package enemies;

public class Vampire extends Enemy {
    public Vampire() {
        super("Vampire", 80, 15, 40);
    }

    @Override
    public int attack() {
        // Логика атаки для вампира
        return attackPower;
    }
}
