package Leetcode.easy;

import Leetcode.common.TreeNode;

import java.util.Stack;

public class LC938_RangeSumOfBST {
    public static void main(String[] args) {

        //     10
        //   5    15
        // 3   7



        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(15);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(7);
        //tree.left.right.right = new TreeNode(1);

        System.out.println(new LC938_RangeSumOfBST().rangeSumBST(tree, 7,15));

    }
    int count;
    public int rangeSumBST(TreeNode root, int L, int R) {


        count =0;

       getSum(root, L,R);
        return count;
    }

    public int getSum(TreeNode root, int L,int R){
        if(root != null){

            if(root.val >= L && root.val <=R){
                count +=root.val;
            }
            //if(L <= root.val)
                getSum(root.left, L,R);
            //if(R >= root.val)
                getSum(root.right, L,R);


        }
        return count;
    }

    public int rangeSumBSTIter(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
