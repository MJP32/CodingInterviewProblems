package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        LC94_BinaryTreeInorderTraversal lc94 = new LC94_BinaryTreeInorderTraversal();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        lc94.inorderTraversal(tree).forEach(k-> System.out.print(k+ " "));
        System.out.println();
        lc94.inorderTraversalIterative(tree).forEach(k-> System.out.print(k+ " "));
        System.out.println();

        TreeNode tree2 = new TreeNode(1);
        tree2.left = null;
        tree2.right = new TreeNode(2);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = null;

        lc94.inorderTraversal(tree2).forEach(k-> System.out.print(k+ " "));
        System.out.println();
        lc94.inorderTraversalIterative(tree2).forEach(k-> System.out.print(k+ " "));
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);


        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while(current !=null ||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current =current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;


        }



        return result;
    }
}
