public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data = null;
    private Node<T> right;
    private Node<T> left;


    public Node(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public int compareTo(Node<T> n) {
        if(this == n){
            return 0;
        }

        if(n == null) {
            return 1;
        }



        return this.getData().compareTo(n.getData());


    }

    // best way to practice tree implementation?

    public T getData() {
        return this.data;
    }
    public  Node<T> getRight() {
        return this.right;
    }

    public boolean hasChildren() {
        return this.getRight() == null || this.getLeft() == null;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setRight(Node<T> n) {
        this.right = n;
    }

    public void setLeft(Node<T> n) {
        this.left = n;
    }


}
