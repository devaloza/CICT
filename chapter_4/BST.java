package chapter_4;

class treeNode {
    int val;
    treeNode left;
    treeNode right;
    public treeNode (int size) {
        this.val = size;
    }
}
class BinarySearchTree {
    public treeNode sortedArrayToBST(int[] array) {
        if (array.length ==0 || array == null) {
            return null;
        }
        return sortedArrayToBST(array, 0, array.length - 1);
    }
    private treeNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end-start) /2;
        treeNode node = new treeNode(array[mid]);
        node.left = sortedArrayToBST(array, start, mid-1);
        node.right = sortedArrayToBST(array, mid+1, end);
        return node;
    }
}
public class BST {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        BinarySearchTree bst = new BinarySearchTree();
        treeNode root = bst.sortedArrayToBST(sortedArray);
        printInOrderTree(root);
    }
    public static void printInOrderTree(treeNode node) {
        if (node == null) {
            return;
        }
        printInOrderTree(node.left);
        System.out.print(node.val+"->");
        printInOrderTree(node.right);
    }
}

