package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.Stack;

public class LC965_UnivalueBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(2);
        //tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(2);


        LC965_UnivalueBinaryTree lc965 = new LC965_UnivalueBinaryTree();
        System.out.println(lc965.isUnivalTree(tree));

    }

    public boolean isUnivalTree(TreeNode root) {


        if (root.left != null) {
            if(!isUnivalTree(root.left))
                return false;
            if(root.left.val != root.val)
                return false;
        }

        if(root.right != null){
            if(!isUnivalTree(root.right))
                return false;
            if(root.right.val != root.val)
                return false;
        }


        return true;
    }
    public boolean isUnivalTreeIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int val = root.val;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if (node.val != val) {
                return false;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }


        }

        return true;



    }

}
