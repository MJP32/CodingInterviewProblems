package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1110_DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        List<TreeNode> forest = new LC1110_DeleteNodesAndReturnForest().delNodes(tree, new int[]{3,5});
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }

        removeNodes(root, toDelete,remaining);
        if(!toDelete.contains(root.val)){
            remaining.add(root);
        }
        return remaining;
    }

    private TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
        if(root == null){
            return null;
        }
        root.left = removeNodes(root.left, toDelete, remaining);
        root.right = removeNodes(root.right, toDelete, remaining);

        if(toDelete.contains(root.val)){
            if(root.left != null){
                //node 6
                remaining.add(root.left);
            }if(root.right != null){
                //node 7
                remaining.add(root.right);
            }
            return null;
        }
        return root;
    }
}
