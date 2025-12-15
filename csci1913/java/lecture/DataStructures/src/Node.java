public class Node<T> {
    // data
    private T nodeData;
    // reference to next node
    private Node<T> nextNode;


    // constructor

    public Node(T nodeData) {
        this.nodeData = nodeData;
        this.nextNode = null;
    }

    //setters
    public void setNodeData(T nodeData) {
        this.nodeData = nodeData;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    // getters

    public T getNodeData() {
        return this.nodeData;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }

}
