package chapter_4;



class TreeNodeThree {
    int val;
    TreeNodeThree left;
    TreeNodeThree right;
    TreeNodeThree parent;

    TreeNodeThree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
public class InOrderSuccessorTwo {
    public static TreeNodeThree inorderSuccessor(TreeNodeThree node) {
        if (node == null) {
            return null;
        }

        // Case 1: If the node has a right subtree, the successor is the leftmost node
        // in the right subtree.
        if (node.right != null) {
            return findLeftmost(node.right);
        }

        // Case 2: If the node doesn't have a right subtree, traverse up the tree until
        // you find an ancestor whose left child is the current node.
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        // If node.parent is null at this point, the input node is the largest in the tree,
        // and there is no successor.
        return node.parent;
    }

    // Helper function to find the leftmost node in a subtree.
    private static TreeNodeThree findLeftmost(TreeNodeThree node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
       /* TreeNodeThree root = new TreeNodeThree(50);
        root.left = new TreeNodeThree(45);
        root.right = new TreeNodeThree(65);
        root.left.left = new TreeNodeThree(40);
        root.left.right = new TreeNodeThree(49);
        root.left.right.left = new TreeNodeThree(44);
        root.left.left.left = new TreeNodeThree(20); // Added node 20
        root.right.left = new TreeNodeThree(52);
        root.right.right = new TreeNodeThree(75);
        root.right.left.left = new TreeNodeThree(53);
        root.right.left.right = new TreeNodeThree(68);
        root.right.right.right = new TreeNodeThree(77);
        root.right.left.left.left = new TreeNodeThree(63);
        root.right.left.left.left.right = new TreeNodeThree(64); */
        TreeNodeThree root = new TreeNodeThree(50);
        TreeNodeThree node45 = new TreeNodeThree(45);
        TreeNodeThree node65 = new TreeNodeThree(65);
        TreeNodeThree node40 = new TreeNodeThree(40);
        TreeNodeThree node49 = new TreeNodeThree(49);
        TreeNodeThree node44 = new TreeNodeThree(44);
        TreeNodeThree node20 = new TreeNodeThree(20); // Added node 20
        TreeNodeThree node52 = new TreeNodeThree(52);
        TreeNodeThree node75 = new TreeNodeThree(75);
        TreeNodeThree node53 = new TreeNodeThree(53);
        TreeNodeThree node68 = new TreeNodeThree(68);
        TreeNodeThree node77 = new TreeNodeThree(77);
        TreeNodeThree node63 = new TreeNodeThree(63);
        TreeNodeThree node64 = new TreeNodeThree(64);

        root.left = node45;
        root.right = node65;
        root.parent = null;

        node45.left = node40;
        node45.right = node49;
        node45.parent = root;

        node40.left = node20; // Added parent reference
        node40.right = null;
        node40.parent = node45;

        node49.left = node44;
        node49.right = null;
        node49.parent = node45;

        node44.left = null;
        node44.right = null;
        node44.parent = node49;

        node20.left = null;
        node20.right = null;
        node20.parent = node40; // Parent reference for node 20

        node52.left = null;
        node52.right = null;
        node52.parent = node65;

        node65.left = node53;
        node65.right = node75;
        node65.parent = root;

        node53.left = null;
        node53.right = null;
        node53.parent = node65;

        node75.left = node68;
        node75.right = node77;
        node75.parent = node65;

        node68.left = node63;
        node68.right = null;
        node68.parent = node75;

        node77.left = null;
        node77.right = null;
        node77.parent = node75;

        node63.left = null;
        node63.right = node64;
        node63.parent = node68;

        node64.left = null;
        node64.right = null;
        node64.parent = node63;

        TreeNodeThree nodeToFindSuccessor = node49;
        TreeNodeThree successor = inorderSuccessor(nodeToFindSuccessor);

        if (successor != null) {
            System.out.println("In-order successor of " + nodeToFindSuccessor.val + " is " + successor.val);
        } else {
            System.out.println(nodeToFindSuccessor.val + " does not have an in-order successor.");
        }
    }
}
