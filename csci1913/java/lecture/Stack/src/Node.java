public class Node {
    private char character;
    private Node next;

    public Node(char c) { character = c; }

    public char getChar() { return character; }

    public void setChar(char c) { character = c;}

    public Node getNext() { return next; }

    public void setNext(Node node) { next = node; }
    public String toString() {
        return "Node: " + this.character;
    }
}