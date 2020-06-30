package Leetcode.easy;

import Leetcode.common.TreeNode;

public class LC270_ClosestBinarySearchTreeValue {
    public static void main(String[] args) {

    }
    double min = Double.MAX_VALUE;
    int ans = 0;
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return ans;
        if(Math.abs((double) root.val - target) < min){
            min = Math.abs((double) root.val - target);
            ans = root.val;
        }
        if(target > (double) root.val)
            closestValue(root.right, target);
        else if(target < (double) root.val)
            closestValue(root.left, target);
        else
            return root.val;

        return ans;
    }
}
