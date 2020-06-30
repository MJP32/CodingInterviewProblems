package Leetcode.easy;

import Leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC993_CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(5);


        System.out.println(new LC993_CousinsInBinaryTree().isCousins(tree, 5, 4));

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //Depths of cousins, if found
        int xDepth = -1;
        int yDepth = -1;

        //Current iteration depth
        int currDepth = -1;

        while(!queue.isEmpty()){
            int size = queue.size();

            //Current depth
            currDepth++;

            while(size > 0){

                TreeNode node = queue.poll();

                //Failfast - If this node is the parent of x and y, they are not cousins
                if(node.left != null && (node.left.val == x || node.left.val == y) && node.right != null && (node.right.val == x || node.right.val == y)) {
                    return false;
                }

                //If this node is one of the cousins, update the corresponding depth
                if(node.val == x || node.val == y) {
                    if(node.val == x)
                        xDepth = currDepth;
                    else if (node.val == y)
                        yDepth = currDepth;

                    //Have we found both cousins so far? Then depths should be the same for cousins
                    if(xDepth >=0 && yDepth >= 0)
                        return xDepth == yDepth;
                }



                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

        }
        return false;

    }
}
