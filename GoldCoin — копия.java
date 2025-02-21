package items;

public class GoldCoin extends Item {
    public GoldCoin() {
        super("Золотая монета", 10);
    }

    @Override
    public void applyEffect() {
        System.out.println("Вы подобрали золотую монету!");
    }
}
