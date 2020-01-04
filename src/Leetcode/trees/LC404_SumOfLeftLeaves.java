package Leetcode.trees;

import Leetcode.common.PrintTree;
import Leetcode.common.TreeNode;

public class LC404_SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        LC404_SumOfLeftLeaves lc404 = new LC404_SumOfLeftLeaves();

        System.out.println(lc404.sumOfLeftLeaves(tree));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int result =0 ;

        if(root == null){
            return 0;
        }

        if(root.left != null){
            if(root.left.left ==null && root.left.right ==null) {
                result += root.left.val;
            }
            else {
                result += sumOfLeftLeaves(root.left);
            }
        }

        if(root.right != null) {
            if (root.right.left != null && root.right.right != null) {

                result += sumOfLeftLeaves(root.right);
            }
        }

        return result;
    }

}
