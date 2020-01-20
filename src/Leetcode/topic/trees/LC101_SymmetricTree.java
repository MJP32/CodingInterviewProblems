package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC101_SymmetricTree {
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(3);

        LC101_SymmetricTree lc101 = new LC101_SymmetricTree();
        System.out.println(lc101.isSymmetric(tree));
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;

        return isSymmetric(root.left, root.right);


    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if(left == null || right ==null){
            return left == right;
        }


        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);


    }
}
