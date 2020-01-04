package Leetcode.trees;

import Leetcode.common.PrintTree;
import Leetcode.common.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC226_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        LC226_InvertBinaryTree lc226 = new LC226_InvertBinaryTree();
        PrintTree pt = new PrintTree();
        pt.printTree(lc226.invertTree(tree)).forEach(k-> System.out.println(k));

    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right =left;
        root.left = right;

        return root;

    }




}
