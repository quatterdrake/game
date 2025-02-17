package src;

public class CombatManager {
    public static void combat(Player player, Enemy enemy) {
        System.out.println("Бой начался: " + player.getName() + " vs " + enemy.getName());

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            // Игрок атакует
            enemy.takeDamage(10);
            System.out.println(player.getName() + " атакует, у врага осталось здоровья: " + enemy.getHealth());

            if (enemy.getHealth() <= 0) {
                System.out.println("Враг побежден!");
                player.gainExperience(50);
                break;
            }

            // Враг атакует
            player.takeDamage(enemy.attack());
            System.out.println(enemy.getName() + " атакует, у игрока осталось здоровья: " + player.getHealth());

            if (player.getHealth() <= 0) {
                System.out.println("Игрок побежден!");
            }
        }
    }
}
