public class CharHash<T> {
    private T[] values = (T[]) new Object[26];
    public int getHash(char c) {
        c = Character.toLowerCase(c);
        if (c >= 'a' && c <= 'z') {

            return (int) c - 97;
        }
        return -1;
    }

    public void put(char key, T value) {
        values[getHash(key)] = value;
    }

    public boolean contains(char key) {
        return values[getHash(key)] != null;
    }

    public T get(char key) {
        return values[getHash(key)];
    }

    public void remove(char key) {
        values[getHash(key)] = null;
    }

    


}
