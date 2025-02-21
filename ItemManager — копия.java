package items;

import java.util.Random;

public class ItemManager {
    private Random random;

    public ItemManager() {
        this.random = new Random();
    }

    public Item generateRandomItem() {
        int choice = random.nextInt(3);
        switch(choice) {
            case 0: return new GoldCoin();
            case 1: return new HealthElixir();
            case 2: return new MagicScroll();
            default: return new GoldCoin();
        }
    }

    public void processItemPickup(Item item) {
        System.out.println("Вы подобрали: " + item.getName());
        item.applyEffect();
    }
}
