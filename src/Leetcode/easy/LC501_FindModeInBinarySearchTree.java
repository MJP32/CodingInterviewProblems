package Leetcode.easy;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC501_FindModeInBinarySearchTree {
    Integer prev = null;
    int count =1;
    int max =0;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(new LC501_FindModeInBinarySearchTree().findMode(tree)));
    }
    public int[] findMode(TreeNode root) {

        List<Integer> modes = new ArrayList<>();

        traverse(root, modes);
        int[] result  = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void traverse(TreeNode node, List<Integer> modes) {

        if (node == null) {
            return;
        }
        traverse(node.left, modes);

        if(prev != null){
            if(prev == node.val){
                count++;
            }
            else{
                count =1;
            }
        }

        if(count > max){
            max = count;
            modes.clear();
            modes.add(node.val);

        }
        traverse(node.right, modes);

    }

}
