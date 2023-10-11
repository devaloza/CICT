package chapter_4;

public class calCulateHeight {
    int val;
    TreeNode left;
    TreeNode right;
    public calCulateHeight(int val) {
        this.val = val;
    }
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the height of the tree
        int height = getHeight(root);

        System.out.println("Height of the tree is: " + height);
    }

}

