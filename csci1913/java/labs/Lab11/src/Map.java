public class Map<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int count;

    public Map(int length) {
        if(length <= 0) {
            length = 1;
        }
        this.keys = (Key[]) new Object[length];
        this.values = (Value[]) new Object[length];

        this.count = 0;
    }

    /**
     * determines if two keys are equal
     * @param leftKey
     * @param rightKey
     * @return true if equal, false otherwise
     */
    private boolean isEqual(Key leftKey, Key rightKey) {
        // if either value is null
        if (leftKey == null || rightKey == null){
            return leftKey == rightKey;
        }
        return leftKey.equals(rightKey);
    }

    /**
     * gets index of a key
     * @param key to find find index of
     * @return index of key in map
     */
    private int getIndex(Key key) {
        for (int i = 0; i < this.keys.length; i ++) {
            // key is found
            if(isEqual(key,keys[i])) {
                return i;
            }
        }
        // default of -1
        return -1;
    }

    /**
     * gets the value for a given key
     * @param key to get value of
     * @return value from map
     */
    public Value get(Key key) {
        int index = this.getIndex(key);

        if (index >= 0){
            // getting value at valid index
            return this.values[index];
        }
        return null;

    }

    /**
     * determines if key is in map
     * @param key key to find
     * @return true if the key exists in map
     */
    public boolean containsKey(Key key){
        for (int i = 0; i < count; i++){
            // if key is found
            if(this.isEqual(keys[i],key)){
                return true;
            }
        }
        return false;
    }

    /**
     * resize both of the current arrays to accommodate a new key
     */
    private void resize() {
        Key[] k = (Key[]) new Object[this.keys.length*2];
        Value[] v = (Value[]) new Object[this.keys.length*2];
        // copying values over into new arrays
        for (int i = 0; i < keys.length; i ++) {
            k[i] = keys[i];
            v[i] = values[i];
        }
        this.keys = k;
        this.values = v;
    }

    /**
     * adds value to map, resizes if necessary
     * @param key key to add
     * @param value value to map key to
     */
    public void put(Key key, Value value) {

        // if key already exists
        if(this.containsKey(key)){

            this.values[this.getIndex(key)] = value;
        } else {
            // if current map is too small
            if (count >= this.keys.length) {

                resize();
                put(key,value);
            } else {
                // adding key to map
                this.keys[count] = key;
                this.values[count] = value;

                // increment count for next add
                count += 1;
            }
        }

    }

    public int size() {
        return this.count;
    }
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < keys.length; i ++) {
            s += (keys[i] + " " + values[i] + "\n");
        }
        return s;
    }
}
