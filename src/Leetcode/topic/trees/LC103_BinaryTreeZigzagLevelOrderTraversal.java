package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        LC103_BinaryTreeZigzagLevelOrderTraversal lc102 = new LC103_BinaryTreeZigzagLevelOrderTraversal();

        lc102.levelOrder(tree).forEach(k-> System.out.println(k));

        System.out.println();

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<>();
        if(root == null){
            return allLevels;
        }


        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        int count =0;

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
            count++;
            if (count %2 ==0) {
                Collections.reverse(level);
            }
            allLevels.add(level);
        }
        return allLevels;
    }
}
