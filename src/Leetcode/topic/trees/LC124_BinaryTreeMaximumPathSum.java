package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC124_BinaryTreeMaximumPathSum {
    int maxPathSum;
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        System.out.println(new LC124_BinaryTreeMaximumPathSum().maxPathSum(tree));
    }

    public int maxPathSum(TreeNode root) {

        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }

    private int pathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        maxPathSum = Math.max(maxPathSum, left+right + root.val);
        return Math.max(left,right) + root.val;


    }
}
