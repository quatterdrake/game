import java.util.*;

public class Player {
    private String name;
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println(item.getName());
            }
        }
    }
}
