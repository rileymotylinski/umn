public class CacheBlockQueue<T> {
    private CacheBlockQueueNode<T> front;
    private CacheBlockQueueNode<T> back;

    private int size;

    public CacheBlockQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    /**
     * adds a node to the queue. Either increments the
     * existing data or adds a new node.
     * @param data data to be added to queue
     */
    public void enqueue(T data) {
        // adding to empty queue
        if (this.isEmpty()) {
            CacheBlockQueueNode<T> newNode = new CacheBlockQueueNode<>(data, null);

            this.front = newNode;
            this.back = newNode;
        // adding to a queue with at least 1 node in it already
        } else {
            // when the element is equal to the current end of the queue
            if (this.back.getData() == data) {
                this.back.incrementCount();
            // when the element is not equal to the current end of the queue
            } else {
                CacheBlockQueueNode<T> newNode = new CacheBlockQueueNode<>(data, null);

                // updating pointer of the back node to the next node
                this.back.setNext(newNode);
                this.back = newNode;
            }

        }
        // updating size of the queue
        this.size += 1;

    }

    /**
     * @return data in the front node
     */
    public T front() { return front != null ? front.getData() : null; }

    /**
     * removes front most node from queue
     * @return data from the front most node
     */
    public T dequeue() {
        // nothing to dequeue
        if (front == null) {
            return null;
        }
        this.size -= 1;
        // don't need to remove any node in queue, just decrementing
        if (front.getCount() > 1) {
            front.decrementCount();
            return front.getData();
        }
        // removing front node
        CacheBlockQueueNode<T> temp = front;
        front = front.getNext();
        return temp.getData();


    }

    public int frontOfLineRepeatCount() {
        return front != null ? front.getCount() : 0;
    }

    public boolean isEmpty() {
        return this.size < 1;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * returns a user-friendly version of the queue
     * @return data:count, data:count, ...
     */
    public String toString() {
        String s = "";
        CacheBlockQueueNode<T> next = front;
        if(next == null) {
            return s;
        }

        while(next != null) {
            s += next.getData() + ":" + next.getCount() + " ";
            next = next.getNext();
        }
        // adding commas to spaces
        return s.strip().replace(" ", ", ");
    }


}
