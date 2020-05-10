package Grokking.CH7_TreeDFS.recursive;



class MaximumPathSum {

    public static int maxPathSum;
    public static int findMaximumPathSum(TreeNode root) {

        maxPathSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);


        return maxPathSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxPathSumFromLeft = findMaximumPathSumRecursive(root.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(root.right);


        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        int localMaximumSum = maxPathSumFromLeft+maxPathSumFromRight+root.val;

        maxPathSum = Math.max(maxPathSum, localMaximumSum);


        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + root.val;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
