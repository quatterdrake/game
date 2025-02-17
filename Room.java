import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> connections;  // Связи с другими комнатами
    private Item item;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.connections = new HashMap<>();
    }

    public void connectRoom(String direction, Room room) {
        connections.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connections.get(direction);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void describe() {
        System.out.println("Room: " + name);
        System.out.println(description);
        if (item != null) {
            System.out.println("Items here: " + item.getName());
        }
    }
}
