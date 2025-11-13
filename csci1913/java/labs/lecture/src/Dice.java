import java.util.Random;

public class Dice {
    private int sides;
    protected Random random = new Random();

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return random.nextInt(1,sides + 1);
    }

    public int getSides() {
        return this.sides;
    }

}
