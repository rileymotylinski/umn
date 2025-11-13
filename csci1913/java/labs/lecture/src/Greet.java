public abstract class Greet {

    private String name;

    protected Greet(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void greet();

}
