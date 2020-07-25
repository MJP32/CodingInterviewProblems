package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC1382_BalanceABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right =  new TreeNode(4);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return constructBalancedSearchTree(inorder, 0, inorder.size()-1);
    }

    private TreeNode constructBalancedSearchTree(List<TreeNode> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start +(end -start)/2;
        TreeNode root = inorder.get(mid);
        root.left = constructBalancedSearchTree(inorder, start, mid-1);
        root.right = constructBalancedSearchTree(inorder, mid+1, end);
        return root;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> inorder) {
        if (root ==null) {
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root);
        inorderTraversal(root.right, inorder);
        root.left = null;
        root.right = null;
    }
}
