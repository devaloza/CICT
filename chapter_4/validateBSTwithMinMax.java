package chapter_4;

public class validateBSTwithMinMax {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // Create an instance of the ValidateBST class
        validateBSTwithMinMax validator = new validateBSTwithMinMax();

        // Check if the tree is a valid BST
        boolean isValid = validator.isValidBST(root);

        // Print the result
        System.out.println("Is the tree a valid BST? " + isValid);
    }
}
