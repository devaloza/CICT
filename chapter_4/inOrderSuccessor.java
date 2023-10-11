package chapter_4;

public class inOrderSuccessor {
    public  TreeNode successor = null;
    public TreeNode getInOrderSuccessor(TreeNode node, int digit) {
        while (node !=null) {
            if (node.val <= digit) {
                node = node.right;
            } else {
                successor = node;
                node = node.left;
            }
        }
        System.out.println(successor.val);
        return successor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        inOrderSuccessor inOrdersucc = new inOrderSuccessor();
        inOrdersucc.getInOrderSuccessor(root, 3);
    }
}
