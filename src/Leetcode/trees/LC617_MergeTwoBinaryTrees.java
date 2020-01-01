package Leetcode.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        LC617_MergeTwoBinaryTrees lc617 = new LC617_MergeTwoBinaryTrees();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);



        TreeNode tree2 = new TreeNode(1);
        tree2.left = null;
        tree2.right = new TreeNode(2);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = null;

        TreeNode node = lc617.mergeTrees(tree, tree2);

        List<Integer> ls = lc617.inorderTraversal(node);

        for(Integer i : ls){
            System.out.print (i + " ");
        }

        System.out.println();


    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val +=t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;


    }




    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);


        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }
}

