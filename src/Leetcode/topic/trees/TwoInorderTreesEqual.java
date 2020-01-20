package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoInorderTreesEqual {
    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(1);
        tree1.right.left = new TreeNode(6);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(6);
        tree2.right.left = new TreeNode(5);
        tree2.right.right = new TreeNode(7);


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(tree1, list1);
        inOrder(tree2, list2);


        System.out.println(list1.equals(list2));

    }

    private static void inOrder(TreeNode tree, List<Integer> list){

        if(tree == null)
            return;

        inOrder(tree.left, list);

        list.add(tree.val);
        inOrder(tree.right,list);

    }




}



