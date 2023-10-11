package chapter_2;

public class deleteDuplicateList {
    public static void main(String[] args) {
        LL node = new LL();
        /* node.insertFirst(13);
        node.insertFirst(5);
        node.insertFirst(14);
        node.insertFirst(15);
        node.insertFirst(16);
        node.insertFirst(11);
        node.insertFirst(17);*/
        node.insertFirst(1);
        node.insertFirst(2);
        node.insertFirst(3);
        node.insertFirst(2);
        node.insertFirst(1);
       // node.display();
       // node.insert(55, 3);
        node.display();
        //System.out.println("");
        //node.deleteFirst();
        //System.out.println("");
        //node.deleteLast();
        System.out.println("");
       // node.delete(2);
        //node.deleteDuplicate();
       // node.deleteDuplicateUsingBuffer();
        //node.displayKthtoLastElement(8); // two pointer
        //node.mainFunction(2); // recorsive
        //node.getPartitionList(15);

       // node.getPartitionList2(15); // working same as getPartitionList()
        System.out.println("");
        //node.sumOfGivenList(LL.Node, LL.Node);
        //node.reverseList();
        //node.recursivereverseList(); // recursive
        System.out.println(node.palindropList());
    }
}
