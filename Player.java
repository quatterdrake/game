package player;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int experience;
    private List<Item> inventory;
    private ScoreManager scoreManager;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
        this.scoreManager = new ScoreManager();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) health = 0;
    }

    public void heal(int amount) {
        health += amount;
        if(health > 100) health = 100;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int exp) {
        experience += exp;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
        scoreManager.addScore(item.getScoreValue());
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public void showInventory() {
        System.out.println("Инвентарь " + name + ":");
        for(Item item: inventory) {
            System.out.println("- " + item.getName());
        }
    }
}
