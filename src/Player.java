package src;

public class Player {
    private String name;
    private int health;
    private int experience;
    private Inventory inventory;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.experience = 0;
        this.inventory = new Inventory();
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void gainExperience(int exp) {
        this.experience += exp;
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public Inventory getInventory() {


        return null;
    }

    // Getters and Setters
}

