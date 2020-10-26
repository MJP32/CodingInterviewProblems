package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC1120_MaximumAverageSubtree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(12);
        tree.right = new TreeNode(18);

        System.out.println(new LC1120_MaximumAverageSubtree().maximumAverageSubtree(tree));
    }
    private double maxResult;
    public double maximumAverageSubtree(TreeNode root) {

        maxResult =0;
        helper(root);
        return maxResult;
    }

    private double[] helper(TreeNode node) {
        if (node == null) {
            return new double[]{0, 0};
        }
        double[] leftResult = helper(node.left);
        double[] rightResult = helper(node.right);
        double totalNodeCount = leftResult[0] + rightResult[0] + 1;
        double sum = leftResult[1] + rightResult[1] + node.val;
        double avg = sum / totalNodeCount;
        if (avg > maxResult) {
            maxResult = avg;
        }
        return new double[]{totalNodeCount, sum};
    }
}
