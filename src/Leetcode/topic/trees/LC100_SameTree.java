package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC100_SameTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);


        System.out.println(new LC100_SameTree().isSameTree(tree, tree2));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }
        else if (p == null ||q == null){
            return false;
        }
        else if(p.val !=q.val){
            return false;
        }
        else{

            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);


        }







    }
}
