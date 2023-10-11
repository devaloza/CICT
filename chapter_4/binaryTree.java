package chapter_4;

import java.util.Scanner;

class binaryTree {

     public binaryTree() {

     }
    private static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    public void populate(Scanner sc) {
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }
    private void populate(Scanner sc, Node n) {
        boolean left = sc.nextBoolean();
        if (left) {
            int leftValue = sc.nextInt();
            n.left = new Node(leftValue);
            populate(sc, n.left);
        }
        boolean right = sc.nextBoolean();
        if (right) {
            int rightValue = sc.nextInt();
            n.right = new Node(rightValue);
            populate(sc, n.right);
        }

    }
}
