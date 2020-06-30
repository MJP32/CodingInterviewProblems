package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC255_VerifyPreorderSequenceinBinarySearchTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        System.out.println(new LC255_VerifyPreorderSequenceinBinarySearchTree().verifyPreorder(new int []{5,2,6,1,3}));
    }
    int idx = 0;
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0)
            return true;
        return verifyPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean verifyPreorder(int[] preorder, int min, int max) {
        if (idx == preorder.length)
            return true;
        int rootVal = preorder[idx];
        if (rootVal < min || rootVal > max)
            return false;
        idx++;
        return verifyPreorder(preorder, min, rootVal-1) || verifyPreorder(preorder, rootVal+1, max);
    }
}
