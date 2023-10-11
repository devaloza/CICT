package chapter_3;

public class shortStack extends customStack {
    private customStack stack1;
    private customStack stack2;
    public shortStack(int size) {
        stack1 = new customStack(size);
        stack2 = new customStack(size);
    }
    public void sortedStack(customStack s1) {
        while (!s1.isEmpty()) {
            int temp = s1.pop();
           /* if (stack2.isEmpty()) {
                stack2.push(temp);
            } else if (temp < stack2.peek()) {
                stack2.push(temp);
            } else { */
                while (!stack2.isEmpty() && temp > stack2.peek()) {
                    s1.push(stack2.pop());
                }
                stack2.push(temp);
                //}
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop()+ " ->");
        }
    }
    public static void main(String[] args) {
        shortStack customNewStack = new shortStack(7);
        customNewStack.stack1.push(1);
        customNewStack.stack1.push(3);
        customNewStack.stack1.push(8);
        customNewStack.stack1.push(12);
        customNewStack.stack1.push(5);
        customNewStack.stack1.push(7);
        customNewStack.stack1.push(10);

        while (!customNewStack.stack1.isEmpty()) {
            System.out.print(customNewStack.stack1.pop()+" -> ");
        }
        System.out.println("");
        customNewStack.stack1.push(1);
        customNewStack.stack1.push(3);
        customNewStack.stack1.push(8);
        customNewStack.stack1.push(12);
        customNewStack.stack1.push(5);
        customNewStack.stack1.push(7);
        customNewStack.stack1.push(10);
        customNewStack.sortedStack(customNewStack.stack1);

    }
}
