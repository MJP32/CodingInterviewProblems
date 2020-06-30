package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC549_BinaryTreeLongestConsecutiveSequence2 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);

        System.out.println(new LC549_BinaryTreeLongestConsecutiveSequence2().longestConsecutive(tree));
    }

    int max;
    public int longestConsecutive(TreeNode root) {

        longestConsecutive(root);
        return max;
    }

    private int[] longestConsecutive(TreeNode root, int count, int target, int[] max) {
        if(root == null) {
            return new int[]{0,0};
        }

        else if(root.val == target) {
            count++;
        }
        else {
            count =1;
        }
        max[0] = Math.max(max[0], count);
        longestConsecutive(root.left, count, root.val+1, max);
        longestConsecutive(root.right, count, root.val+1, max);

        return new int[0];
    }
}
