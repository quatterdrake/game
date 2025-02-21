package enemies;

public abstract class Enemy {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int experienceReward;

    public Enemy(String name, int health, int attackPower, int experienceReward) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.experienceReward = experienceReward;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) health = 0;
    }

    public abstract int attack();
}
