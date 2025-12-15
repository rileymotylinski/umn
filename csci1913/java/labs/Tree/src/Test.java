public class Test {
    public static void main(String[] arge) {
        Tree<Character> t = new Tree<>();
        t.addNode(new Node<>('M'));
        System.out.println(t.getRoot().getData());

        t.addNode(new Node<>('O'));
        System.out.println(t.getRoot().getLeft().getData());

        t.addNode(new Node<>('F'));
        System.out.println(t.getRoot().getRight().getData());

        t.addNode(new Node<>('A'));

        System.out.println(t.search('O'));
    }



}
