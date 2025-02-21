package enemies;

public class Zombie extends Enemy {
    public Zombie() {
        super("Zombie", 60, 8, 25);
    }

    @Override
    public int attack() {
        // Логика атаки для зомби
        return attackPower;
    }
}
