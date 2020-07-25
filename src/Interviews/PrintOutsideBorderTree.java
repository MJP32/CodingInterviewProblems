package Interviews;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintOutsideBorderTree {
    public static void main(String[] args) {
        /*
                        1
               2              3
            4       5      6        7
 `        8   9   10 11  12 13    14 15

         */


        //1,2,4,8,9,10,11,12,13,14,15,7,3


        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left.left = new TreeNode(12);
        tree.right.left.right = new TreeNode(13);
        tree.right.right.left = new TreeNode(14);
        tree.right.right.left = new TreeNode(15);

       /* TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(4);*/


        new PrintOutsideBorderTree().printBoundary(tree).forEach(k-> System.out.println(k));
    }

    private List<Integer> printBoundary(TreeNode tree) {
        List<Integer> result = new ArrayList<>();

        getLeft(tree, result);
        getLeaves(tree, result);
        getRight(tree, result);
        return result;
    }

    private void getLeaves(TreeNode tree, List<Integer> result) {
        if(tree == null)
            return;

        getLeaves(tree.left, result);

        if(tree.left == null && tree.right == null ){
            result.add(tree.val);

        }

        getLeaves(tree.right, result);
    }

    private void getLeft(TreeNode tree, List<Integer> result) {
        if(tree == null)
            return;

        if(tree.left != null){
            result.add(tree.val);
            getLeft(tree.left, result);
        }
        else if(tree.right != null){
            result.add(tree.val);
            getLeft(tree.right, result);
        }

    }

    private void getRight(TreeNode tree, List<Integer> result) {
        if(tree == null)
            return;

        if(tree.right != null){
            getRight(tree.right, result);
            result.add(tree.val);
        }
        else if(tree.left != null){
            getRight(tree.left, result);
            result.add(tree.val);
        }

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<>();
        if(root == null){
            return allLevels;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i < size;i++){
                TreeNode p = queue.poll();
                level.add(p.val);
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }
            allLevels.add(level);
        }
        return allLevels;
    }




}
