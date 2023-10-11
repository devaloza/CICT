package chapter_3;

public class implementNstacks {
    private int numberOfStacks = 3;
    private int sizeOfStacks;
    private int[] values;
    private int[] sizes;

    public implementNstacks(int sizeOfStacks) {
        this.sizeOfStacks = sizeOfStacks;
        values = new int[sizeOfStacks * numberOfStacks];
        sizes = new int[numberOfStacks];
    }
    public boolean push(int stackNumber, int value) throws Exception {
        if (isFull(stackNumber)) {
            throw  new Exception();
        }
        sizes[stackNumber]++;
        values[indexOfTopElement(stackNumber)] = value;
        return true;
    }
    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw  new Exception();
        }
        sizes[stackNum]--;
        int indexVal = indexOfTopElement(stackNum);
        int val = values[indexVal];
        values[indexVal] = 0;
        return val;
    }
    public int peek(int stackNum) throws Exception{
        if (isEmpty(stackNum)) {
            throw  new Exception();
        }
        return values[indexOfTopElement(stackNum)];
    }
    public boolean isFull(int stackNumber) {
        return sizes[stackNumber] == sizeOfStacks;
    }
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
    public int indexOfTopElement(int stackNum) {
        int offset = stackNum * sizeOfStacks;
        int size = sizes[stackNum];
        return offset+size-1;
    }
}
