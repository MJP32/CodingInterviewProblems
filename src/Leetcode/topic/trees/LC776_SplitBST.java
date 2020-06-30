package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

public class LC776_SplitBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(7);

        TreeNode[] treeArr = new LC776_SplitBST().splitBST(tree, 2);

        for (TreeNode n : treeArr) {
            System.out.println(n.val);
        }

    }

    public TreeNode[] splitBST(TreeNode root, int V) {


        if (root == null) {
            return new TreeNode[]{null, null};
        } else if (root.val <= V) {
            TreeNode[] bns = splitBST(root.right, V);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            TreeNode[] bns = splitBST(root.left, V);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }


    }
}
