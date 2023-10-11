package chapter_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ListOfDepths {
    public List<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<TreeNode> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(levelList);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ListOfDepths solution = new ListOfDepths();
        List<LinkedList<TreeNode>> depthLists = solution.listOfDepths(root);

        // Print the result
        for (int i = 0; i < depthLists.size(); i++) {
            System.out.print("Depth " + i + ": ");
            LinkedList<TreeNode> depthList = depthLists.get(i);
            for (TreeNode node : depthList) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}
