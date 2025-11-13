public class ProduceQuantity<T, K> {
    private T produce;
    private K number;
    public ProduceQuantity(T produce, K number) {
        this.produce = produce;
        this.number = number;
    }

    public K getQuantity() {
        return this.number;
    }

    public T getItem() {
        return this.produce;
    }
}
