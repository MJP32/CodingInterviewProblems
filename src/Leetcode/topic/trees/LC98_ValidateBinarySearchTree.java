package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC98_ValidateBinarySearchTree {

/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        System.out.println(new LC98_ValidateBinarySearchTree().isValidBST(tree));


        TreeNode notBstTree = new TreeNode(1);
        notBstTree.left = new TreeNode(2);
        notBstTree.right = new TreeNode(30);
        notBstTree.left.left = new TreeNode(4);
        notBstTree.left.right = new TreeNode(-50);

        System.out.println(new LC98_ValidateBinarySearchTree().isValidBST(notBstTree));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        else if(root.val >=max || root.val <= min){
            return false;
        }
        else{
            return isValidBST(root.left,  min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
        }
    }

}
