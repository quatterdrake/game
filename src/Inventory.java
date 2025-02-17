package src;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void useItem(Item item) {
        // Применить эффект предмета
        System.out.println("Использован предмет: " + item.getName() + ", Эффект: " + item.getEffect());
    }

    // Getters and Setters
}
