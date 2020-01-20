package Leetcode.common;

public class Tree {

    public TreeNode getTree(){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);


        return tree;
    }


}
