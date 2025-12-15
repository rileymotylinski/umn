public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] children;

    public TrieNode() {
        this.data = null;
        this.children = (TrieNode<T>[]) new TrieNode[26];
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Hash for child in TrieNode. Creates a new node if it doesn't already exist
     * @param letter where in the hash to search
     * @return either found TrieNode or new TrieNode
     */
    public TrieNode<T> getChild(char letter) {
        // checking if it *can* exist in children. Basically needs to be hash-able.
        if(!Character.isLowerCase(letter) || !Character.isAlphabetic(letter)) {
            return null;
        }
        // gets current value in children
        TrieNode<T> childNode = this.children[(int) letter - 'a'];

        if (childNode != null) {
            // returning found TrieNode
            return childNode;
        }
        // Creating new TrieNode
        this.children[(int) letter - 'a'] = new TrieNode<T>();
        // now the trie node will be found
        return getChild(letter);
    }

    /**
     * recursively counting child nodes
     * @return total child nodes of this TrieNode
     */
    public int getTreeSize() {
        // counting initial node
        int total = 1;

        for (int i = 0; i < this.children.length; i++){
            if(children[i] != null) {
                total += this.children[i].getTreeSize();
            }

        }
        return total;
    }
}
