package Leetcode.topic.trees.kardio;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC654_MaximumBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new LC654_MaximumBinaryTree().constructMaximumBinaryTree(new int []{3,2,1,6,0,5});

        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        result.forEach(k-> System.out.println(k));
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right,result) ;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int start, int end){

        int index = getMaxIndex(nums, start, end);
        if (index ==-1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index-1);
        root.right = helper(nums, index+1, end);
        return root;

    }

    private int getMaxIndex(int[] nums, int start, int end){
        int index = -1;
        int max = -1;
        for (int i  = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index =i;
            }

        }
        return index;
    }

}
