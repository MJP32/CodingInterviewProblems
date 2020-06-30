package Leetcode.easy;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC107_BinaryTreeLevelOrderTraversal2 {
        List<List<Integer>> allLevels = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        new LC107_BinaryTreeLevelOrderTraversal2().levelOrderBottom(tree).forEach(k-> System.out.println(k));
//        new LC107_BinaryTreeLevelOrderTraversal2().levelOrderBottom(tree);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return allLevels;
        }
        helper(root, 0);
        Collections.reverse(allLevels);

        return allLevels;
    }

    private void helper(TreeNode root, int level) {
        if (allLevels.size() == level) {
            allLevels.add(new ArrayList<Integer>());
        }
        allLevels.get(level).add(root.val);

        if(root.left != null){
            helper(root.left, level +1);
        }

        if(root.right != null){
            helper(root.right, level +1);
        }

    }
}
