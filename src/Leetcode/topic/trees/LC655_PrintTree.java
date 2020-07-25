package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC655_PrintTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        new LC655_PrintTree().printTree(tree).forEach(k-> System.out.println(k));
    }
    public class ppair{ // this class will store a node & 2 indexes -> first & last.
        TreeNode node = null;
        int first;
        int last;

        public ppair(TreeNode node, int first, int last){
            this.first = first;
            this.node = node;
            this.last = last;
        }
    }

    public int height(TreeNode root){
        if(root == null) return -1;
        return Math.max(height(root.left), height(root.right))+ 1;
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if(root == null) return ans;

        int h = height(root);  //find the height of the tree
        int n = (int)(Math.pow(2, h+1) - 1);  //n represents the total nodes in binary tree.
        //size of our List will be n.

        // every node will store a range of index (start to end)
        LinkedList<ppair> que = new LinkedList<>();
        que.addLast(new ppair(root, 0, n));   // initially root node will have [0,n] index range.

// The aim is to calculate the mid index using the start and end index and place the data of node at that index in our List.

        while(que.size() != 0){
            int size = que.size();
            List<String> res = new ArrayList<>();
            for(int i=0; i<n; i++){
                res.add("");
            }
            while(size-- >0){
                ppair rnode = que.removeFirst();

                int mid = (rnode.first + rnode.last)/2;  // calculate the mid for the node using the indexes.
                String value = Integer.toString(rnode.node.val);
                res.set(mid, value);  //place the data of that node in its correct index i.e at mid.

                if(rnode.node.left != null){
                    // for left child start index will be same, but end index will be at mid.
                    que.addLast(new ppair(rnode.node.left, rnode.first, mid));
                }
                if(rnode.node.right != null){
                    // for right child end index will be same while start index will become mid+1.
                    que.addLast(new ppair(rnode.node.right, mid+1, rnode.last));
                }
            }

            ans.add(res);
        }

        return ans;
    }
}
