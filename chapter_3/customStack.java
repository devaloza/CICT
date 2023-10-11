package chapter_3;

public class customStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int pointer = -1;
    public customStack() {
        this(DEFAULT_SIZE);
    }
    public customStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            return false;
        }
        pointer++;
        data[pointer] = item;
        return true;
    }

    public boolean isFull() {
        return pointer == data.length-1;
    }
    public boolean isEmpty() {
        return pointer == -1;
    }
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
       // pointer--;
        return data[pointer--];
    }
    public int peek() {
        return data[pointer];
    }
}
