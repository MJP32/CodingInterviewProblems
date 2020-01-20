package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC513_BottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        LC513_BottomLeftTreeValue lc4513= new LC513_BottomLeftTreeValue();

        System.out.println(lc4513.findBottomLeftValue(tree));


    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            root =queue.poll();
            if(root.right != null){
                queue.offer(root.right);
            }
            if(root.left != null){
                queue.offer(root.left);
            }

        }
        return root.val;
    }
}
