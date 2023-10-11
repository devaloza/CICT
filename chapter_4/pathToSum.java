package chapter_4;

public class pathToSum {
    public static int countPathWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int pathFromRoot = countPathFromRootNode(root, targetSum, 0);
        int pathFromLeftNode = countPathWithSum(root.left, targetSum);
        int pathFromRightNode = countPathWithSum(root.right, targetSum);
        return pathFromRoot+pathFromLeftNode+pathFromRightNode;
    }
    private static int countPathFromRootNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null) return 0;
        currentSum += root.val;
        int path = 0;
        if (currentSum == targetSum) {
            path++;
        }
        path += countPathFromRootNode(root.left, targetSum, currentSum);
        path += countPathFromRootNode(root.right, targetSum, currentSum);
        return path;
    }
}
