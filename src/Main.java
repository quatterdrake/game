package src;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Игрок1", 100);
        Enemy enemy = new Enemy("Враг1", 50, 15);
        Item sword = new Item("Меч", "Увеличивает урон на 5");

        player.addItem(sword);

        // Применяем предмет
        player.getInventory().useItem(sword);

        // Инициация боя
        CombatManager.combat(player, enemy);

        // Прокачка
        LevelManager levelManager = new LevelManager();
        levelManager.levelUp(player);
    }
}
