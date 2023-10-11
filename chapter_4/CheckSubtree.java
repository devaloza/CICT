package chapter_4;

import com.sun.source.tree.Tree;

public class CheckSubtree {
    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (checkedClonedTree(root1, root2)) {
            return true;
        }

        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
    private static boolean checkedClonedTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        return (tree1 == tree2) && checkedClonedTree(tree1.left, tree2.left) && checkedClonedTree(tree1.right, tree2.right);
    }
}
