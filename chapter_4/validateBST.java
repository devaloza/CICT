package chapter_4;

import java.util.Stack;

public class validateBST {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev !=null && prev.val >=root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Create an instance of the ValidateBST class
        validateBST validator = new validateBST();

        // Check if the tree is a valid BST
        boolean isValid = validator.isValidBST(root);

        // Print the result
        System.out.println("Is the tree a valid BST? " + isValid);
    }
}
