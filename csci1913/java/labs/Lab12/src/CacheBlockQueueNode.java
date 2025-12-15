public class CacheBlockQueueNode<T> {
    private T data;

    private int count;
    private CacheBlockQueueNode<T> next;

    public CacheBlockQueueNode(T data, CacheBlockQueueNode<T> next) {
        this.data = data;
        this.next = next;
        this.count = 1;


    }

    public T getData() {
        return this.data;
    }

    public int getCount() {
        return this.count;
    }

    public CacheBlockQueueNode<T> getNext() { return this.next; }

    public void setData(T data) { this.data = data; }
    public void setCount(int count) { this.count = count; }
    public void setNext(CacheBlockQueueNode<T> next) { this.next = next; }

    public void incrementCount() { this.count += 1; }
    public void decrementCount() { this.count -= 1; }
}
