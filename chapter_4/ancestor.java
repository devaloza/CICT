package chapter_4;

public class ancestor {
    public static TreeNode ancestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        TreeNode leftsubtree = ancestor(root.left, node1, node2);
        TreeNode rightsubtree = ancestor(root.right, node1, node2);
        if (leftsubtree != null && rightsubtree !=null) {
            return root;
        } else if (leftsubtree !=null) {
            return leftsubtree;
        } else {
            return rightsubtree;
        }
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ancestor binaryTree = new ancestor();

        TreeNode node1 = root.left.left;  // Node with value 4
        TreeNode node2 = root.left.right; // Node with value 5

        TreeNode commonAncestor = binaryTree.ancestor(root, node1, node2);

        if (commonAncestor != null) {
            System.out.println("The first common ancestor is: " + commonAncestor.val);
        } else {
            System.out.println("No common ancestor found.");
        }
    }
}
