public class List<T> {

    // What is a list?
    // stores information in order allocates space in memory
    // How do we use Lists?

    // What methods do we need
    // get items in a list
    // adding/removing items
    // shifting (when prepending/replaces)
    // sort

    private T[] data;
    private int length = 0;
    private int size = 50;

    public List() {
        // creating of size n
        // has to start somewhere
        data = (T[]) new Object[size];

    }

    public int length() {
        return this.length;
    }

    private boolean withinBounds(int index) {
        return (index >= 0 && index < this.length);
    }

    public T get(int i) {
        if (withinBounds(i)) {
            throw new RuntimeException("index out of range");
        }
        return data[i];
    }

    public boolean set(int i, T el) {
        if(withinBounds(i)) {
            this.data[i] = el;
            return true;
        }
        return false;

    }

    private void expandArray() {
        T[] oldData = this.data;
        this.size *= 2;
        this.data = (T[]) new Object[size];


        // copy into new list
        for(int i = 0; i < oldData.length; i++) {
            this.data[i] = oldData[i];
        }
    }

    public boolean append(T el) {
        if (this.length < this.size) {
            this.data[length] = el;
            this.length += 1;
            return true;

        } else if (length == size) {
            expandArray();

            this.append(el);
        }
        return false;
    }

    public boolean prepend(T el) {
        shiftRight(0);

        this.data[0] = el;
        this.length += 1;

        return true;
    }

    public boolean insert(int index, T el) {
        shiftRight(index);

        this.data[index] = el;
        this.length += 1;

        return true;
    }

    private void shiftRight(int index){
        if(this.length == this.size){
            expandArray();
        }
        for (int i = this.length; i > index; i++){
            this.data[i] = this.data[i-1];
        }
    }

    private void shiftLeft(int index) {
        for(int i = index; i < length; i++){
            data[i] = data[i+1];
        }
        length--;
    }

    public String toString() {
        String s = "";
        for(T el : this.data) {
            s += el + ", ";
        }
        return s;
    }
    public void pop(){
        shiftLeft(0);
    }
    public void remove(int index) {
        shiftLeft(index);
    }
}
