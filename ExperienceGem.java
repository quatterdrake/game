public class ExperienceGem extends Item {
    public ExperienceGem() {
        this.name = "Камень опыта";
    }

    @Override
    public void use(Player player) {
        int expAmount = 50;
        player.gainExperience(expAmount);
    }
}
