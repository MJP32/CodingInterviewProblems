package FB;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberVisibleNodes {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(10);
        tree.left.right = new TreeNode(6);
        tree.left.left = new TreeNode(1);
        tree.right.right = new TreeNode(14);
        tree.right.right.left = new TreeNode(13);
        tree.left.right.left = new TreeNode(4);
        tree.left.right.right = new TreeNode(7);
        new NumberVisibleNodes().rightSideView(tree).forEach(k-> System.out.println(k));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i =0 ; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(i == 0){
                    results.add(currentNode.val);
                }
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        return results;
    }
}
