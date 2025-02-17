import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MUDController {
    private Player player;
    private boolean running = true;

    public MUDController(Player player) {
        this.player = player;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            handleInput(input);
        }
    }

    public void handleInput(String input) {
        String[] commandParts = input.split(" ");
        String command = commandParts[0];
        String argument = (commandParts.length > 1) ? commandParts[1] : null;

        switch (command.toLowerCase()) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
                break;
            case "inventory":
                player.showInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

    private void lookAround() {
        player.getCurrentRoom().describe();
    }

    private void move(String direction) {
        if (direction == null || direction.isEmpty()) {
            System.out.println("You need to specify a direction.");
            return;
        }

        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction);
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            System.out.println("You need to specify an item to pick up.");
            return;
        }

        List<Item> itemsInRoom = player.getCurrentRoom().getItems();
        for (Item item : itemsInRoom) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                player.getCurrentRoom().removeItem(item);
                player.addItem(item);
                System.out.println("You picked up the " + itemName);
                return;
            }
        }
        System.out.println("No item named " + itemName + " here!");
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describes the current room.");
        System.out.println("move <forward|back|left|right> - Moves the player in the specified direction.");
        System.out.println("pick up <itemName> - Picks up an item from the room.");
        System.out.println("inventory - Lists the items the player is carrying.");
        System.out.println("help - Displays this help information.");
        System.out.println("quit/exit - Ends the game.");
    }
}
