import java.util.Scanner;

public class MUDController {
    private Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine();
            handleInput(input);
        }
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
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
            case "quit":
            case "exit":
                running = false;
                System.out.println("Exiting game.");
                break;
            case "help":
                showHelp();
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
        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You move " + direction + " to the " + nextRoom.getName());
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        Item item = player.getCurrentRoom().getItem();
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            player.addItemToInventory(item);
            player.getCurrentRoom().setItem(null);  // Убираем предмет из комнаты
            System.out.println("You pick up the " + item.getName());
        } else {
            System.out.println("No item named " + itemName + " here!");
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Look around the current room.");
        System.out.println("move <direction> - Move in the specified direction.");
        System.out.println("pick up <item> - Pick up an item from the room.");
        System.out.println("inventory - Show your inventory.");
        System.out.println("quit/exit - Exit the game.");
    }
}
