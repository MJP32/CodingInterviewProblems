package KeepOnCoding;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoTreesInorderTraversalEqual {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(1);
        tree1.right = new TreeNode(7);
        tree1.right.left = new TreeNode(6);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(6);
        tree2.right.left = new TreeNode(5);
        tree2.right.right = new TreeNode(7);

        List<Integer> list1 = new ArrayList<>();
        //List<Integer> list2 = new ArrayList<>();
        inOrderTravwersal(tree1, list1);
        //inOrderCheck(tree2, list1);

        System.out.println(inOrderCheck(tree2, list1) && list1.isEmpty());
    }

    private static boolean inOrderCheck(TreeNode root, List<Integer> list ){
        if(root == null){
            return true;
        }

        if(!inOrderCheck(root.left, list))
            return false;
        if(list.isEmpty() ||list.get(0) != root.val){
            return false;
        }
        list.remove(0);
        //list.add(root.val);
        return inOrderCheck(root.right, list);

    }

    private static void inOrderTravwersal(TreeNode root, List<Integer> list ){
        if(root == null){
            return;
        }

        inOrderTravwersal(root.left, list);
        list.add(root.val);
        inOrderTravwersal(root.right, list);

    }
}
