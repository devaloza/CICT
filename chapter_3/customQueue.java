package chapter_3;

public class customQueue {
    private static final int DEFAULT_SIZE  = 10;
    int end = 0;
    protected int[] data;
    public customQueue() {
        this(DEFAULT_SIZE);
    }
    public customQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }
    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception();
        }
        int value = data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return value;
    }
}
