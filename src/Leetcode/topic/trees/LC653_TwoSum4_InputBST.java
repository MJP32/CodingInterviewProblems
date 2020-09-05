package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC653_TwoSum4_InputBST {
    boolean exists;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(7);
        System.out.println(new LC653_TwoSum4_InputBST().findTarget(tree, 13));
    }

    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inOrderTraversal(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }


    }
}
