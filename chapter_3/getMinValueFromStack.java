package chapter_3;


public class getMinValueFromStack extends customStack {
    private customStack mainStack = new getMinValueFromStack(10);
    private customStack subStack = new minStack();
    public getMinValueFromStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (isFull()) {
            return false;
        }
        if (item <=min()) {
            subStack.push(item);
        }
        super.push(item);
        System.out.println(subStack.peek());
        return true;
    }

    @Override
    public int pop() {
        int removeValue = super.pop();
        if (removeValue == min()) {
            subStack.pop();
        }
        return removeValue;
    }

    public int min() {
        if (subStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return subStack.peek();
    }
    public class minStack extends customStack {
        public minStack() {
            super();
        }
    }

    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//
//        minStack.push(3);
//        minStack.push(5);
//        minStack.push(2);
//        minStack.push(1);
//
//        System.out.println("Minimum element: " + minStack.min()); // Output: 1
//
//        minStack.pop();
//        minStack.pop();
//
//        System.out.println("Minimum element: " + minStack.min()); // Output: 3
    }
}
