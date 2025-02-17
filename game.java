import java.util.*;

// Интерфейсы для DIP
interface Combat {
    void attack(Player player, Enemy enemy);
}

interface ItemEffect {
    void applyEffect(Player player);
}

// Класс игрока
class Player {
    private String name;
    private int health = 100;
    private int experience = 0;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил урон " + damage + ". Осталось здоровья: " + health);
    }

    public void gainExperience(int exp) {
        experience += exp;
        System.out.println(name + " получил " + exp + " опыта. Текущий опыт: " + experience);
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " получил предмет: " + item.getName());
    }

    public boolean isAlive() {
        return health > 0;
    }
}

// Класс врага
class Enemy {
    private String type;
    private int health;
    private int attackPower;

    public Enemy(String type, int health, int attackPower) {
        this.type = type;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(type + " получил урон " + damage + ". Осталось здоровья: " + health);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

// Менеджер боя
class CombatManager implements Combat {
    public void attack(Player player, Enemy enemy) {
        enemy.takeDamage(20);
        if (enemy.isDefeated()) {
            System.out.println("Враг побежден!");
            player.gainExperience(50);
        } else {
            player.takeDamage(enemy.getAttackPower());
        }
    }
}

// Классы предметов
class Item {
    private String name;
    private ItemEffect effect;

    public Item(String name, ItemEffect effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void use(Player player) {
        effect.applyEffect(player);
    }
}

class HealthPotion implements ItemEffect {
    public void applyEffect(Player player) {
        System.out.println("Зелье здоровья восстановило 30 HP!");
    }
}

// Класс управления уровнем
class LevelManager {
    private int level = 1;

    public void levelUp(Player player) {
        level++;
        System.out.println("Поздравляем! Новый уровень: " + level);
    }
}

// Основной игровой класс
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя игрока: ");
        Player player = new Player(scanner.nextLine());
        CombatManager combatManager = new CombatManager();
        LevelManager levelManager = new LevelManager();
        Enemy goblin = new Enemy("Гоблин", 50, 10);

        System.out.println("Вы встретили гоблина!");
        while (player.isAlive() && !goblin.isDefeated()) {
            System.out.println("Атаковать? (y/n)");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                combatManager.attack(player, goblin);
            } else {
                break;
            }
        }

        if (goblin.isDefeated()) {
            levelManager.levelUp(player);
        }

        System.out.println("Игра окончена.");
        scanner.close();
    }
}
