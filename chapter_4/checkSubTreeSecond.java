package chapter_4;

public class checkSubTreeSecond {
    public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        } else if (t1.val == t2.val && matched(t1, t2)) {
            return true;
        }
        return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }
    public static boolean matched(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2== null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
            return matched(t1.left, t2.left) && matched(t1.right, t2.right);
        }
    }
}
