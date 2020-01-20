package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.LinkedList;

public class LC104_MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        LC104_MaximumDepthBinaryTree lc104 = new LC104_MaximumDepthBinaryTree();
        System.out.println(lc104.maxDepth(tree));
        System.out.println(lc104.maxDepthIter(tree));

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) +1;
        }
    }

    public int maxDepthIter(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        int depth =0;
        int currDepth =0;

        if(root == null){
            return 0;
        }
        stack.add(root);
        depths.add(1);

        while(!stack.isEmpty()){
            root = stack.pollLast();
            currDepth = depths.pollLast();

            if (root != null) {
                depth = Math.max(depth,currDepth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(currDepth +1);
                depths.add(currDepth +1);
            }


        }


        return depth;
    }
}
