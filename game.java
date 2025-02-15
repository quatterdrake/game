import java.util.*;

interface Enemy {
    void attack(Player player);
    String getName();
    int getExperienceReward();
}

interface Item {
    void use(Player player);
    String getName();
}

class Player {
    private String name;
    private int health;
    private int experience;
    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " получил " + amount + " урона! Здоровье: " + health);
    }

    public void gainExperience(int amount) {
        experience += amount;
        System.out.println(name + " получил " + amount + " опыта! Опыт: " + experience);
    }

    public void addToInventory(Item item) {
        inventory.add(item);
        System.out.println(name + " получил " + item.getName() + " в инвентарь!");
    }
}

class Goblin implements Enemy {
    private int health = 30;

    public void attack(Player player) {
        int damage = 10;
        System.out.println("Гоблин атакует!");
        player.takeDamage(damage);
    }

    public String getName() {
        return "Гоблин";
    }

    public int getExperienceReward() {
        return 20;
    }
}

class Orc implements Enemy {
    private int health = 50;

    public void attack(Player player) {
        int damage = 15;
        System.out.println("Орк атакует!");
        player.takeDamage(damage);
    }

    public String getName() {
        return "Орк";
    }

    public int getExperienceReward() {
        return 30;
    }
}

class Troll implements Enemy {
    private int health = 70;

    public void attack(Player player) {
        int damage = 20;
        System.out.println("Тролль атакует!");
        player.takeDamage(damage);
    }

    public String getName() {
        return "Тролль";
    }

    public int getExperienceReward() {
        return 40;
    }
}

class HealthPotion implements Item {
    public String getName() {
        return "Зелье здоровья";
    }

    public void use(Player player) {
        int healAmount = 20;
        System.out.println(player.getName() + " выпил зелье! + " + healAmount + " HP.");
    }
}

class ExperienceGem implements Item {
    public String getName() {
        return "Камень опыта";
    }

    public void use(Player player) {
        int expAmount = 50;
        player.gainExperience(expAmount);
    }
}

class Level {
    private int number;

    public Level(int number) {
        this.number = number;
    }

    public void start(Player player) {
        System.out.println("📍 Начало уровня " + number + " для " + player.getName() + "!");
    }
}

public class Game {
    private Player player;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        System.out.print("Введите имя героя: ");
        this.player = new Player(scanner.nextLine());
    }

    public void start() {
        System.out.println("🎮 Добро пожаловать в игру, " + player.getName() + "!");
        Level level = new Level(1);
        level.start(player);
        Random random = new Random();
        List<Enemy> enemies = List.of(new Goblin(), new Orc(), new Troll());

        while (player.getHealth() > 0) {
            System.out.print("\nЧто делать? (fight/pick/use/status/exit): ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "fight":
                    Enemy enemy = enemies.get(random.nextInt(enemies.size()));
                    System.out.println("⚔️ Битва началась! Противник: " + enemy.getName());
                    enemy.attack(player);
                    if (player.getHealth() > 0) {
                        System.out.println("🎉 Победа! Ты получаешь " + enemy.getExperienceReward() + " опыта.");
                        player.gainExperience(enemy.getExperienceReward());
                    }
                    break;

                case "pick":
                    Item item = random.nextBoolean() ? new HealthPotion() : new ExperienceGem();
                    player.addToInventory(item);
                    break;

                case "use":
                    if (!player.getInventory().isEmpty()) {
                        System.out.println("🎒 Твой инвентарь:");
                        for (int i = 0; i < player.getInventory().size(); i++) {
                            System.out.println((i + 1) + ". " + player.getInventory().get(i).getName());
                        }
                        System.out.print("Выбери предмет (номер): ");
                        if (scanner.hasNextInt()) {
                            int choice = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consume newline
                            if (choice >= 0 && choice < player.getInventory().size()) {
                                player.getInventory().get(choice).use(player);
                                player.getInventory().remove(choice);
                            }
                        } else {
                            System.out.println("⚠️ Некорректный ввод!");
                            scanner.nextLine(); // Очищаем ввод
                        }
                    } else {
                        System.out.println("📭 Инвентарь пуст!");
                    }
                    break;

                case "status":
                    System.out.println("💖 Здоровье: " + player.getHealth() + " | ⭐ Опыт: " + player.getExperience());
                    break;

                case "exit":
                    System.out.println("👋 Выход из игры.");
                    return;

                default:
                    System.out.println("⚠️ Неизвестная команда!");
            }
        }
        System.out.println("💀 Ты умер. Игра окончена.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
