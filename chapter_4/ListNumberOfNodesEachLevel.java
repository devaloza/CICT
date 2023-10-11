package chapter_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeNew {
    int val;
    TreeNodeNew left;
    TreeNodeNew right;

    TreeNodeNew(int val) {
        this.val = val;
    }
}
public class ListNumberOfNodesEachLevel {
    public List<LinkedList<TreeNodeNew>> listofdepth(TreeNodeNew root) {
        List<LinkedList<TreeNodeNew>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNodeNew> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<TreeNodeNew> levelList = new LinkedList<>();
            for (int i=0; i< levelSize; i++) {
                TreeNodeNew newNode = queue.poll();
                levelList.add(newNode);
                if (newNode.left !=null) {
                    queue.offer(newNode.left);
                }
                if (newNode.right !=null) {
                    queue.offer(newNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNodeNew root = new TreeNodeNew(1);
        root.left = new TreeNodeNew(2);
        root.right = new TreeNodeNew(3);
        root.left.left = new TreeNodeNew(4);
        root.left.right = new TreeNodeNew(5);
        root.right.left = new TreeNodeNew(6);
        root.right.right = new TreeNodeNew(7);

        ListNumberOfNodesEachLevel solution = new ListNumberOfNodesEachLevel();
        List<LinkedList<TreeNodeNew>> depthLists = solution.listofdepth(root);

        // Print the result
        for (int i = 0; i < depthLists.size(); i++) {
            System.out.print("Depth " + i + ": ");
            LinkedList<TreeNodeNew> depthList = depthLists.get(i);
            for (TreeNodeNew node : depthList) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}
