package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC545_BoundaryOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(4);

        new LC545_BoundaryOfBinaryTree().boundaryOfBinaryTree(tree).forEach(k-> System.out.println(k));

    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null )
            return result;
        else if(root.right == null && root.left == null){
            result.add(root.val);
            return result ;
        }


        result.add(root.val);
        getLeft(root.left, result);

        getLeaves(root, result);
        getRight(root.right, result);

        return result;
    }
    public void getLeaves(TreeNode node, List<Integer> result){

        if(node == null)
            return;

        getLeaves(node.left, result);
        if(node.left == null && node.right == null){
            result.add(node.val);
        }
        getLeaves(node.right, result);
    }

    public void getRight(TreeNode node, List<Integer> result){

        if(node == null)
            return;

        if(node.right != null){

            getRight(node.right, result);
            result.add(node.val);

        }
        else if(node.left != null){

            getRight(node.left, result);
            result.add(node.val);
        }

    }

    public void getLeft(TreeNode node, List<Integer> result){
        if(node == null)
            return;

        if(node.left != null){
            result.add(node.val);
            getLeft(node.left, result);

        }
        else if(node.right != null){
            result.add(node.val);
            getLeft(node.right, result);

        }

    }
}
