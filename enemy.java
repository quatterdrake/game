public abstract class Enemy {
    protected int health;
    protected int damage;
    protected String name;
    protected int experienceReward;

    public String getName() {
        return name;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public void attack(Player player) {
        System.out.println(name + " атакует!");
        player.takeDamage(damage);
    }
}
