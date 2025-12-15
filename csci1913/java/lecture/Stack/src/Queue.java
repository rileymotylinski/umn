public class Queue {

    private Node front;
    private Node back;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    public void enqueue(Node n) {
        // What are the cases when you add the queue?

        // adding to empty queue
        if(this.front == null && this.back == null) {
            this.front = n;
            this.back = n;
            return;
        }
        // adding to end of queue
        this.back.setNext(n);
        this.back = n;
    }

    public Node dequeue() {
        // empty queue
        if(this.front == null && this.back == null) {
            return null;
        }

        // dequeue from front of queue
        Node n = this.front;
        this.front = n.getNext();

        // if only one node left in the queue,
        // emptied queue; have to reset back too.
        if(this.front == null) {
            this.back = null;
        }
        return n;
    }
}
