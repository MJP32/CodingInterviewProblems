package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        System.out.println(new Codec().serialize(tree));
       TreeNode deserializedTree =  new Codec().deserialize("1,2,4,X,X,5,X,X,3,X,X,");
        printLevelOrder(deserializedTree);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "X,";
        }

        String leftSubtree = serialize(root.left);
        String rightSubtree = serialize(root.right);

        return root.val+"," + leftSubtree+rightSubtree;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);

    }
    public TreeNode deserializeHelper(Queue<String> nodesLeft){
        String valueForNode = nodesLeft.poll();
        if(valueForNode.equals("X")){
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);
        return newNode;
    }

    // Iterative method to do level order traversal line by line
    static void printLevelOrder(TreeNode root)
    {
        // Base Case
        if(root == null)
            return;

        // Create an empty queue for level order tarversal
        Queue<TreeNode> q =new LinkedList<TreeNode>();

        // Enqueue Root and initialize height
        q.add(root);


        while(true)
        {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                TreeNode node = q.peek();
                System.out.print(node.val + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }
}