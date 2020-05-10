package Grokking.CH7_TreeDFS.iterative;


import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class L1_TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {


        if(root == null){
            return false;
        }
 /*
        sum -=root.val;
        if (root.left == null && root.right == null) {
            return sum ==0;
        }

        return hasPath(root.left, sum) || hasPath(root.right, sum);
        */


        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();

        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int currSum;

        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            currSum = sumStack.pollLast();

            if (node.right == null && node.left == null && currSum ==0) {
                return true ;
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }

        }

        return false;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + L1_TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + L1_TreePathSum.hasPath(root, 16));
    }
}
