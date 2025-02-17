package src;

public class LevelManager {
    public void levelUp(Player player) {
        if (player.getExperience() >= 100) {
            System.out.println(player.getName() + " повышен до следующего уровня!");
            // Увеличение характеристик игрока
        }
    }
}

