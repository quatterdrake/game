package combat;

import player.Player;
import enemies.Enemy;

public class CombatManager {
    public void engageCombat(Player player, Enemy enemy) {
        System.out.println("Начался бой между " + player.getName() + " и " + enemy.getName());

        while(player.getHealth() > 0 && enemy.isAlive()){
            // Атака игрока по врагу
            int playerAttack = calculatePlayerAttack(player);
            enemy.takeDamage(playerAttack);
            System.out.println(player.getName() + " наносит " + enemy.getName() + " " + playerAttack + " урона.");

            if(!enemy.isAlive()){
                System.out.println(enemy.getName() + " побеждён!");
                player.addExperience(enemy.getExperienceReward());
                break;
            }

            // Атака врага по игроку
            int enemyAttack = enemy.attack();
            player.takeDamage(enemyAttack);
            System.out.println(enemy.getName() + " наносит " + player.getName() + " " + enemyAttack + " урона.");
        }

        if(player.getHealth() <= 0){
            System.out.println(player.getName() + " был побеждён. Игра окончена.");
        }
    }

    private int calculatePlayerAttack(Player player) {
        // Упрощённый расчёт урона игрока: базовый урон плюс бонус от опыта
        return 10 + (player.getExperience() / 10);
    }
}
