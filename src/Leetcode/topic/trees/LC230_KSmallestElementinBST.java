package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC230_KSmallestElementinBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.right = new TreeNode(2);


        System.out.println(new LC230_KSmallestElementinBST().kthSmallest(tree, 1));
    }
    public int kthSmallest(TreeNode root, int k) {

        int[] nums = new int[2];

        inOrderTraversal(root, nums, k);


        //result.forEach(l-> System.out.println(l));


        return nums[1];

    }


    private void inOrderTraversal(TreeNode root, int[] nums, int k ) {

        if(root == null){
            return;
        }
        inOrderTraversal(root.left,nums, k ) ;
        if(nums[0]++ == k){
            nums[1] = root.val;
            return;
        }
        inOrderTraversal(root.right,nums, k ) ;
    }




}
