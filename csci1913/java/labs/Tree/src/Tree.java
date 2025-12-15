public class Tree<T extends Comparable<T>> {
    // height of a tree is number of edges
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    private void addNode(Node<T> head, Node<T> n){

        // n > head
        if (head.compareTo(n) > 0) {
            if(head.getRight() != null) {
                addNode(head.getLeft(), n);
            // doesn't have child
            } else {
                head.setRight(n);
            }

        }
        // n < head
         else if (head.compareTo(n) < 0) {
            if (head.getLeft() != null) {
                addNode(head.getRight(), n);
            // doesn't have child
            } else {
                head.setLeft(n);
            }

        }

    }

    public Node<T> getRoot() {
        return this.root;
    }

    // protecting root
    public void addNode(Node<T> n) {
        if (root == null) {
            root = n;
            return;
        }

        addNode(this.root, n);

    }

    private String toString(Node<T> current) {
        // add to string root -> left -> right
        String s = "";

        if (current == null) return "";

        if (current.getLeft() != null){

            s += toString(current.getLeft());

        }
        s += current.getData();

        if (current.getRight() != null){

            s += toString(current.getRight());

        }
        return s;
    }

    private Node<T> search(Node<T> n, T value){
        // if n == null -> return None/null

        if (n == null) {
            return null;
        }
        System.out.println(n.getData());

        // if value == n.data -> return node
        if (n.getData().compareTo(value) == 0) {
            System.out.println("found");
            return n;
        }


        // if value > n.data -> return search(n.rightNode, value)
        if(n.getData().compareTo(value) < 0){
            return search(n.getRight(),value);
        }

        // if value < n.data -> return search(n.leftNode, value)
        return search(n.getLeft(),value);




    }

    // not optimal
    // start with the other function first, then you can easily implement this function
    public Node<T> search(T value) {
        // look at root node
        if (root.getData().compareTo(value) == 0) {
            return root;
        }
        // if value > rootNode.value && rootNode.rightNode != null -> return search(rootNode.rightNode, value)
        if (root.getData().compareTo(value) > 0 && root.getRight() != null) {
            System.out.println("right");
            return search(root.getRight(),value);

        }
        // if value < rootNode.value && rootNode.leftNode != null -> return search(rootNode.leftNode, value)
        if (root.getData().compareTo(value) < 0 && root.getLeft() != null) {
            System.out.println("left");
            return search(root.getLeft(),value);
        }

        return null;

    }

    public T findMin() {

        Node<T> currentNode = root;

        while(currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode.getData();
    }

    public T findMax() {

        Node<T> currentNode = root;

        while(currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode.getData();
    }

    public String toString() {

        // 3 different ways of traversing tree
        // Depth First Traversal
        // - in order: left -> root -> right (prints in ordered list)
        // - preorder: root -> left -> right (deleting tree one by one)
        // Breadth First Traversal
        // - array/queue
        String s = "";
        if (root != null) {

            s += toString(root);
        }

        return s;



    }

    // find node to remove and its parent
    private Node<T> remove(Node<T> node, Node<T> parent, T value) {


    }

    public void remove(T value) {
        // removing leaf - very easy
        // removing w/ children - have to deal with children
        // - smallest to right (guaranteed to be bigger than everything on left and less than everything on right)
        // - biggest to left (guaranteed to be smaller than everything on right and bigger than everything on right)

        Node<T> parent = null;
        Node<T> current = null;

        while(current != null && current.getData().compareTo(value) != 0) {
            if (current.getData().compareTo(value) > 0){
                parent = current;
                current = current.getLeft();
            }
            else {
                parent = current;
                current = current.getRight();

            }

        }
        if (current != null) {
            remove(parent,current);
        }




    }
}
