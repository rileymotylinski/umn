public class Test {

    public static void main(String[] args) {
        Queue q = new Queue();
        Node n = new Node('c');

        q.enqueue(n);
        q.enqueue(new Node('d'));

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
