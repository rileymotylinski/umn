public class Stack {

    private Node head;

    public void push(char c) {
        Node newNode = new Node(c);
        newNode.setNext(head);
        head = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        char c = head.getChar();

        if (head.getNext() != null) {
            head = head.getNext();
        } else {
            head = null;
        }
        return c;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
