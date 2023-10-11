package chapter_2;

import java.util.HashSet;

public class LL {
    private Node head;
    private Node tail;

    private int size;

    public LL(){
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public static class Index {
        public int value = 0;
    }

    public class Result {
        public Node resultTail;
        public int size;
        public Result(Node resultTail, int size) {
            this.resultTail = resultTail;
            this.size = size;
        }
    }
    public  void mainFunction(int index){
        Node result = kthToLast(head, index);
        System.out.println(result.value);
    }
    public static Node kthToLast(Node head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    public static Node kthToLast(Node head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        Node node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int val) {
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insert(int val, int index) {
        if (index ==0) {
            insertFirst(val);
        } else if (index == size) {
            insertLast(val);
        } else {
            Node temp = head;
            for (int i=1; i < index; i++){
                temp = temp.next;
            }
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        display();
    }
    public void deleteLast(){
        if (size <=1) {
            deleteFirst();
        }
        Node secondLastNode = get(size-2);
        tail = secondLastNode;
        tail.next = null;
        size--;
        display();
    }

    public void delete(int index) {
        if (index == 0) {
             deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        Node deleteBeforeNode = get(index-1);
        deleteBeforeNode.next = deleteBeforeNode.next.next;
        size--;
        display();
    }

    public void deleteDuplicate(){
        Node current = head;
        while (current !=null) {
            Node runningNode = current;
            while (runningNode.next!=null){
                if(runningNode.next.value == current.value) {
                    runningNode.next = runningNode.next.next;
                    size--;
                } else {
                    runningNode = runningNode.next;
                }
            }
            current = current.next;
        }
        display();
    }
    public void deleteDuplicateUsingBuffer() {
        Node current = head;
        HashSet<Integer> buffer = new HashSet<Integer>();
        buffer.add(current.value);
        while (current.next!=null){
            if(buffer.contains(current.next.value)){
                current.next = current.next.next;
                size--;
            } else {
                buffer.add(current.value);
                current = current.next;
            }
        }
        display();
    }
    public void getPartitionList(int x) {
         Node temp = partitionNodes(head, x);
         //display();
        while (temp != null) {
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
    }
    public void getPartitionList2(int x) {
        Node temp  = partitionNodes2(head, x);
        //display();
        while (temp != null) {
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
    }
    private Node partitionNodes(Node head, int val) {
        Node beforXlist = new Node(0);
        Node afterXlist = new Node(0);
        Node beforeX = beforXlist;
        Node afterX = afterXlist;
        while (head != null){
            if (head.value < val) {
                beforeX.next = head;
                beforeX = beforeX.next;
                //beforeX = head;
            } else {
                afterX.next = head;
                afterX = afterX.next;
                //afterX = head;
            }
            head = head.next;
        }
        beforeX.next = afterXlist.next;
        afterX.next = null;
        return beforXlist.next;
    }
    private Node partitionNodes2(Node head, int val) {
        Node beforXlist = new Node(0);
        Node afterXlist = new Node(0);
        Node beforeX = beforXlist;
        Node afterX = afterXlist;
        while (head != null){
            if (head.value < val) {
                beforeX.next = head;
               // beforeX = beforeX.next;
                beforeX = head;
            } else {
                afterX.next = head;
                //afterX = afterX.next;
                afterX = head;
            }
            head = head.next;
        }
        beforeX.next = afterXlist.next;
        afterX.next = null;
        return beforXlist.next;
    }
    //Leetcode
    public Node sumOfGivenList(Node l1, Node l2) {
        Node resultNode = new Node(0);
        Node current = resultNode;
        int carry = 0;
        //int sum = 0;
        while (l1 !=null || l2 !=null){
            int x = (l1 != null) ? l1.value : 0;
            int y = (l2 != null) ? l2.value : 0;
            int tempSum = carry + x + y;
            carry = tempSum / 10;
            //resultNode.value = carry;
            current.next = new Node(tempSum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            //sum +=node1.value + node2.value;
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return resultNode.next;
    }
    public void recursivereverseList() {
        reverseLinkListRec(head);
    }
    private void reverseLinkListRec(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseLinkListRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
        //display();
    }
    public boolean palindropList() {
        Node reverseAndClone = reverseList();
        display();
        return isEqual(head, reverseAndClone);
    }
    public boolean isEqual(Node n1, Node n2) {
        while (n1 !=null && n2 != null) {
            if (n1.value != n2.value) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1==null && n2==null;
    }
    public Node reverseList() {
        Node previous = null;
        Node present = head;
        Node next = present.next;
        while (present !=null) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = previous;
        //display();
        return  previous;
    }
    public boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast !=null && fast.next !=null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public int cycleLength() {
        Node slow = head;
        Node fast = head;
        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return 0;
        }
        slow = slow.next;
        int cycleLength = 0;
        while (slow != fast) {
            cycleLength++;
            slow = slow.next;
        }
        return  cycleLength;
    }
    public Node cycleStartNode() {
        Node slow = head;
        Node fast = head;
        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow !=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return  slow;
    }
    public Node intersection(Node l1, Node l2) {
        Result result1Tail = getTailWithSize(l1);
        Result result2Tail = getTailWithSize(l2);
        if (result1Tail.resultTail != result2Tail.resultTail) {
            return null;
        }
        Node shorter = result1Tail.size < result2Tail.size ? l1 : l2;
        Node longer = result1Tail.size < result2Tail.size ? l2 : l1;
        longer = getKthNode(longer, (result1Tail.size - result2Tail.size));
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }
    public Node getKthNode(Node n, int index) {
        while (index > 0 && n !=null) {
            n = n.next;
            index--;
        }
        return n;
    }
    public Result getTailWithSize(Node n) {
        Node current = n;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void displayKthtoLastElement(int index) {
        Node follower = head;
        Node runner = head;
        int i =0;
        while (i < index) {
            if (runner.next == null) return;
            runner = runner.next;
            i++;
        }
        while (runner != null) {
            follower = follower.next;
            runner = runner.next;
        }
        System.out.println(follower.value);
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
    }
}
