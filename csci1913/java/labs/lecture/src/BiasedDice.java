

public class BiasedDice extends Dice {
    private int favored;
    private double bias;

    public BiasedDice(int sides){
        super(sides);

    }



    @Override
    public int roll() {

        if(random.nextDouble() < bias) {
            return favored;
        }

        int choice = random.nextInt(getSides()) + 1;

        while (choice == favored) {
            choice = random.nextInt(getSides()) + 1;
        }
        return choice;

    }

    public int getFavored() {
        return this.favored;
    }

    public double getBias() {
        return this.favored;
    }

    public void setFavoredSide(int favored, double bias) {
        this.favored = favored;
        this.bias = bias;
    }
}
