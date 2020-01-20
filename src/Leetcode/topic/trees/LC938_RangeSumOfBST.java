package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.Stack;

public class LC938_RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        LC938_RangeSumOfBST lc938 = new LC938_RangeSumOfBST();
        System.out.println(lc938.rangeSumBST(tree, 10, 30 ));
    }

        int rangeSum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum = 0;
        rangeSumBSTRecursive(root, L, R);

        return rangeSum;
    }


    public int rangeSumBSTRecursive(TreeNode root, int L, int R) {

        if(root != null){

            if (root.val >= L && root.val <= R) {
                rangeSum +=root.val;
            }

            if(root.val > L){
                rangeSumBSTRecursive(root.left, L, R);
            }

            if(root.val < R){
                rangeSumBSTRecursive(root.right, L, R);
            }

        }

        return rangeSum;
    }


    public int rangeSumBSTIter(TreeNode root, int L, int R) {

        int rangeSum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if (node.val >= L && node.val <= R) {
                    rangeSum +=node.val;
                }
                if(node.val > L){

                    stack.push(node.left);
                }
                if(node.val < R){
                    stack.push(node.right);
                }
            }




        }

        return rangeSum;

    }
}
