package level;

import enemies.Enemy;
import enemies.Skeleton;
import enemies.Zombie;
import enemies.Vampire;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private int currentLevel;
    private Random random;

    public LevelManager() {
        this.currentLevel = 1;
        this.random = new Random();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void advanceLevel() {
        currentLevel++;
        System.out.println("Переход на следующий уровень! Сейчас уровень " + currentLevel);
    }

    public List<Enemy> spawnEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        int numEnemies = random.nextInt(3) + 1; // от 1 до 3 врагов
        for(int i = 0; i < numEnemies; i++){
            int type = random.nextInt(3);
            switch(type) {
                case 0: enemies.add(new Skeleton()); break;
                case 1: enemies.add(new Zombie()); break;
                case 2: enemies.add(new Vampire()); break;
            }
        }
        return enemies;
    }
}
