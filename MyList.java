public class MyList<T> {
    private int size;
    private int capacity;
    private T[] array;

    public MyList(){
        this.size = 0;
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
    }
    public MyList(int internalCapacity){
        this.size = 0;
        this.capacity = internalCapacity;
        this.array = (T[]) new Object[internalCapacity];
    }

    public void add(T value){
        if (this.getSize() >= this.getCapacity()){
            this.capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < this.getSize(); i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[this.size] = value;
        this.size++;
    }

    public void size(){
        System.out.println("Dizinin boyutu : " + this.getSize());
    }

    public T getIndex(int index){
        if (index < 0 || index > this.size){
            return null;
        }else {
            return this.array[index];
        }
    }

    public T remove(int index){
        if (index < 0 || index < this.getSize()){
            return null;
        }
        T removedValue = this.array[index];
        for (int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        this.array[size-1] = null;
        size--;
        return removedValue;
    }

    public T set(int index,T value){
        if (index < 0 || index < this.getSize()){
            return null;
        }
        return this.array[index] = value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(array[i]);
            if (i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T value){
        for (int i = 0; i < getSize(); i++){
            if (this.array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value){
        for (int i = this.getSize() - 1; i >= 0; i--){
            if (this.array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T[] toArray(){
        T[] newArray = (T[]) new Object[this.getSize()];

        for (int i = 0; i < this.getSize(); i++){
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    public void clear(){
        for (int i = 0; i < this.getSize(); i++){
            this.array[i] = null;
        }
        this.setSize(0);
    }

    public MyList<T> sublist(int start, int finish){
        MyList<T> subList = new MyList<>(finish-start+1);
        for(int i = start; i <=finish; i++){
            subList.add(this.getIndex(i));
        }
        return subList;
    }

    public boolean contains(T value){
        for (int i = 0; i < this.getSize(); i++){
            if (this.array[i].equals(value)){
                return true;
            }
        }
        return false;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
