package chapter_3;

public class queueViaStack extends customStack {
   private customStack pushStack;
    private customStack popStack;

    public queueViaStack(int size) {
        //super(size);
        pushStack = new customStack(size);
        popStack = new customStack(size);
    }

    public void enqueue(int value) {
        pushStack.push(value);
    }

    public int dequeue() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.isEmpty()) {
            return 0;
        }
        return popStack.pop();
    }

    public static void main(String[] args) {
        queueViaStack myQueue = new queueViaStack(3);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println(myQueue.dequeue()); // Should print 1
        System.out.println(myQueue.dequeue()); // Should print 2

        myQueue.enqueue(4);

        System.out.println(myQueue.dequeue()); // Should print 3
        System.out.println(myQueue.dequeue()); // Should print 4
    }
}
