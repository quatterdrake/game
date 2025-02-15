public class HealthPotion extends Item {
    public HealthPotion() {
        this.name = "Зелье здоровья";
    }

    @Override
    public void use(Player player) {
        int healAmount = 20;
        player.takeDamage(-healAmount); // Отрицательное значение — это восстановление
        System.out.println(player.getName() + " выпил зелье! Здоровье: " + player.getHealth());
    }
}
