package Interviews;

import Leetcode.common.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {

        /*

         Given a binary tree, print the vertical order of the tree


             9
            /\
           /  \
           1   8
          /\  /\
         /  \/  \
         4  53   2

        // [[4], [1], [9, 5, 3], [8], [2]]

        */


        TreeNode tree = new TreeNode(9);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(2);

        BinaryTreeVerticalOrderTraversal lc404 = new BinaryTreeVerticalOrderTraversal();

        System.out.println(lc404.verticalOrder(tree));
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;

        Queue<Pair> queue = new LinkedList<>(); //node, horizontal distance
        queue.offer(new Pair(root, 0));

        Hashtable<Integer, List<Integer>> columnTable = new Hashtable<>(); //horizontal distance, list of node values
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {   //i did a level-wise bfs out of habit, but the plain bfs also works.
                Pair p = queue.poll();
                TreeNode node = p.key;
                int position = p.value;
                if (!columnTable.containsKey(position)) {
                    columnTable.put(position, new ArrayList<Integer>());
                }
                columnTable.get(position).add(node.val);
                if (node.left != null)
                    queue.offer(new Pair(node.left, position - 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, position + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);

        for (int k : sortedKeys) {
            output.add(columnTable.get(k));
        }
        return output;

    }

    public class Pair {
        public TreeNode key;
        public int value;

        public Pair(TreeNode key, int value) {
            this.key = key;
            this.value = value;
        }


    }

}
