package chapter_4;

public class checkBalanced {
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftTreeHeight = getHeight(node.left);
        int rightTreeHeight = getHeight(node.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        checkBalanced checker = new checkBalanced();
        boolean isBalanced = checker.isBalanced(root);

        if (isBalanced) {
            System.out.println("The binary tree is balanced.");
        } else {
            System.out.println("The binary tree is not balanced.");
        }
    }
}
