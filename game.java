import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
}
