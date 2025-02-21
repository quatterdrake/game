import player.Player;
import combat.CombatManager;
import items.ItemManager;
import items.Item;
import level.LevelManager;
import enemies.Enemy;
import java.util.List;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя игрока: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        CombatManager combatManager = new CombatManager();
        ItemManager itemManager = new ItemManager();
        LevelManager levelManager = new LevelManager();

        System.out.println("Добро пожаловать, " + player.getName() + "! Игра начинается...");

        boolean gameRunning = true;
        while(gameRunning && player.getHealth() > 0) {
            System.out.println("\n--- Уровень " + levelManager.getCurrentLevel() + " ---");

            // Спавн врагов на уровне
            List<Enemy> enemies = levelManager.spawnEnemies();

            for(Enemy enemy : enemies) {
                System.out.println("На пути враг: " + enemy.getName());
                combatManager.engageCombat(player, enemy);
                if(player.getHealth() <= 0) {
                    gameRunning = false;
                    break;
                }
            }

            if(!gameRunning) break;

            // Шанс подбора предмета
            System.out.println("Вы находите предмет...");
            Item item = itemManager.generateRandomItem();
            itemManager.processItemPickup(item);
            player.addItem(item);

            System.out.println("Ваше текущее здоровье: " + player.getHealth());
            System.out.println("Ваш опыт: " + player.getExperience());
            System.out.println("Ваш счёт: " + player.getScoreManager().getScore());

            // Предложение перейти на следующий уровень или завершить игру
            System.out.print("Перейти на следующий уровень? (yes/no): ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("yes")){
                levelManager.advanceLevel();
            } else {
                gameRunning = false;
            }
        }

        System.out.println("Игра окончена! Финальный счёт: " + player.getScoreManager().getScore());
        scanner.close();
    }
}
