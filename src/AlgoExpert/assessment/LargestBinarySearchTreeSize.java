package AlgoExpert.assessment;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LargestBinarySearchTreeSize {

/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(7);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(8);
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(9);

        tree.right.left = new TreeNode(5);
        tree.right.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(15);
        tree.right.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(22);
        tree.right.right.right = new TreeNode(22);
        tree.right.left.left = new TreeNode(2);
        tree.right.left.left.left = new TreeNode(1);
        System.out.println(new LargestBinarySearchTreeSize().largestBstSize(tree));


//        TreeNode notBstTree = new TreeNode(1);
//        notBstTree.left = new TreeNode(2);
//        notBstTree.right = new TreeNode(30);
//        notBstTree.left.left = new TreeNode(4);
//        notBstTree.left.right = new TreeNode(-50);
//
//        System.out.println(new LargestBinarySearchTreeSize().isValidBST(notBstTree));
    }
    int max =0;
    public  int largestBstSize(TreeNode tree) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(tree, result);
        result.forEach(k-> System.out.println(k));

        return max;
    }

    private int inorderTraversal(TreeNode root, List<Integer> result) {


        if(root != null){
            inorderTraversal(root.left, result);
            if(isValidBST(root)) {
                result.add(root.val);
                max = Math.max(result.size() +1,max);
                //System.out.println(max);
            }
            inorderTraversal(root.right, result);
        }
        return max;
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
