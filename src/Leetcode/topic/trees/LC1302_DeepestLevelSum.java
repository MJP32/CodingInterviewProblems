package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1302_DeepestLevelSum {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);


        System.out.println(new LC1302_DeepestLevelSum().deepestLeavesSum(tree));
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum =0;
        while(!queue.isEmpty()){
            sum =0;
            int size = queue.size();
            for(int i =0;i< size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }


        }
        return sum;
    }
}
