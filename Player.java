import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int experience;
    private List<Item> inventory;
    private Room currentRoom;

    public Player(String name, Room startRoom) {
        this.name = name;
        this.health = 100;  // Начальное здоровье
        this.experience = 0;  // Начальный опыт
        this.inventory = new ArrayList<>();
        this.currentRoom = startRoom;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void gainExperience(int amount) {
        this.experience += amount;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
