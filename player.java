import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int experience;
    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " получил " + amount + " урона! Здоровье: " + health);
    }

    public void gainExperience(int amount) {
        experience += amount;
        System.out.println(name + " получил " + amount + " опыта! Опыт: " + experience);
    }

    public void addToInventory(Item item) {
        inventory.add(item);
        System.out.println(name + " получил " + item.getName() + " в инвентарь!");
    }
}
