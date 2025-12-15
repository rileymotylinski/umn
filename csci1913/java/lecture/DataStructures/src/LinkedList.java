public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(Node<T> head) {
        this.head = head;
        this.tail = head;
        this.length = 1;
    }
    public void append(Node<T> node){
        this.tail.setNextNode(node);
        this.tail = node;
        this.length++;
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

    // easier to implement recursively, but must split into two functions
    public Node<T> search(T data) {
        Node<T> node = head;
        // no binary search in linked list
        while (node != null){

            if (node.getNodeData().equals(data)){
                return node;
            }
            node = node.getNextNode();
        }

        return null;
    }
    public void removeNode(Node<T> node) {
        Node<T> curNode = head;
        Node<T> previousNode = null;

        while(curNode != null) {
            if(curNode == node) {
                if (previousNode != null){
                    previousNode.setNextNode(node.getNextNode());
                    return;
                } else {
                    this.head = curNode.getNextNode();
                }
                // Garbage collection
                // why not use doubly linked list
            }
            previousNode = curNode;
            curNode = curNode.getNextNode();
        }
    }
    // public void removeNode(T value)
}
