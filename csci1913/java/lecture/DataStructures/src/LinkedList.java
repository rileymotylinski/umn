public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(Node<T> head) {
        this.head = head;
        this.tail = head;
    }
    public void append(Node<T> node){
        this.tail.setNextNode(node);
        this.tail = node;
    }

    public String toString() {
        String s = "";

        Node<T> lastNode = this.head;

        while(lastNode != null) {
            s += lastNode.getNodeData();
            lastNode = lastNode.getNextNode();
        }
        return s;
    }

    // public void removeNode(Node<T> node)
    // public void removeNode(T value)
}
