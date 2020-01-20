package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.Stack;

public class LC112_PathSum {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);


        LC112_PathSum lc112 = new LC112_PathSum();
        System.out.println(lc112.hasPathSum(tree, 7));
        System.out.println(lc112.hasPathSum(tree, 72));

    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.add(root);
        sumStack.add(sum- root.val);

        while(!nodeStack.isEmpty()){
            TreeNode currNode = nodeStack.pop();
            int currSum = sumStack.pop();


            if(currNode.left == null && currNode.right == null && currSum ==0){
                return true;
            }
            if(currNode.left != null){
                nodeStack.add(currNode.left);
                sumStack.add(currSum-currNode.left.val);
            }
            if(currNode.right != null){
                nodeStack.add(currNode.right);
                sumStack.add(currSum-currNode.right.val);
            }
        }

        return false;
    }
}
