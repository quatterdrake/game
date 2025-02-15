public class Level {
    private int number;

    public Level(int number) {
        this.number = number;
    }

    public void start(Player player) {
        System.out.println("📍 Начало уровня " + number + " для " + player.getName() + "!");
    }
}
