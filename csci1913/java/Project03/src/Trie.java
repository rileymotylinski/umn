public class Trie<T> {
    private TrieNode<T> root;

    public Trie() {
        this.root = new TrieNode<T>();

    }

    /**
     * gets node in trie, null if the node DNE
     * @param s string to find in the trie
     * @return Trie node that contains s, null otherwise
     */
    private TrieNode<T> getNode(String s) {
        // start at root
        TrieNode<T> currentNode = root;
        // iterate through each character in s
        for (Character c :  s.toCharArray()) {
            currentNode = currentNode.getChild(c);
            // hit the point where there exists no trie node for string
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * gets data in the trie node with s
     * @param s string to find node with
     * @return data in the trie node that contains s
     */
    public T get(String s) {
        TrieNode<T> result = this.getNode(s);
        // node must exist to get data from it
        return result == null ? null : result.getData();
    }

    /**
     * puts a value into the Trie
     * @param s value to search for in the Trie
     * @param value what to add to the TrieNode at S
     */
    public void put(String s, T value) {
        TrieNode<T> result = this.getNode(s);
        if (result != null) {
            // adding data to Trie
            result.setData(value);
        }


    }
}
