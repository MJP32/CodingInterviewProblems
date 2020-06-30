package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        LC102_BinaryTreeLevelOrderTraversal lc102 = new LC102_BinaryTreeLevelOrderTraversal();
        System.out.println(lc102.levelOrder(tree));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<>();
        if(root == null){
            return allLevels;
        }


        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);



        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i < size;i++){

                TreeNode p = queue.poll();
                level.add(p.val);
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }
            allLevels.add(level);
        }
        return allLevels;
    }
}
