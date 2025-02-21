package items;

public class HealthElixir extends Item {
    private int healingAmount;

    public HealthElixir() {
        super("Эликсир здоровья", 20);
        this.healingAmount = 20;
    }

    @Override
    public void applyEffect() {
        System.out.println("Использован эликсир здоровья! Восстановлено " + healingAmount + " единиц здоровья.");
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}
