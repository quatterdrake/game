import java.util.*;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> connectedRooms = new HashMap<>();
    private List<Item> items = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void connect(String direction, Room room) {
        connectedRooms.put(direction.toLowerCase(), room);
    }

    public Room getConnectedRoom(String direction) {
        return connectedRooms.get(direction.toLowerCase());
    }

    public void describe() {
        System.out.println("Room: " + name);
        System.out.println(description);
        if (items.isEmpty()) {
            System.out.println("No items here.");
        } else {
            System.out.println("Items here:");
            for (Item item : items) {
                System.out.println(item.getName());
            }
        }
    }
}
