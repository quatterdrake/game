package items;

public class MagicScroll extends Item {
    public MagicScroll() {
        super("Магический свиток", 15);
    }

    @Override
    public void applyEffect() {
        System.out.println("Использован магический свиток! Таинственная сила пробуждена.");
    }
}
