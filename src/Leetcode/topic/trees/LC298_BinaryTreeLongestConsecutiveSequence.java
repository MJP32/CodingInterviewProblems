package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC298_BinaryTreeLongestConsecutiveSequence {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(2);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(5);

        System.out.println(new LC298_BinaryTreeLongestConsecutiveSequence().longestConsecutive(tree));
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        longestConsecutive(root, 0, 0, max);
        return max[0];
    }

    private void longestConsecutive(TreeNode root, int count, int target, int[] max) {
        if(root == null) {
            return;
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
    }
}
