package items;

public abstract class Item {
    protected String name;
    protected int scoreValue;

    public Item(String name, int scoreValue) {
        this.name = name;
        this.scoreValue = scoreValue;
    }

    public String getName() {
        return name;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public abstract void applyEffect();
}
