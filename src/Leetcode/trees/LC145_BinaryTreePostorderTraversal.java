package Leetcode.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        LC145_BinaryTreePostorderTraversal lc145 = new LC145_BinaryTreePostorderTraversal();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        lc145.postorderTraversal(tree).forEach(k-> System.out.print(k+ " "));
        System.out.println();
        lc145.postorderTraversalIterative(tree).forEach(k-> System.out.print(k+ " "));
        System.out.println();

        TreeNode tree2 = new TreeNode(1);
        tree2.left = null;
        tree2.right = new TreeNode(2);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = null;

        lc145.postorderTraversal(tree2).forEach(k-> System.out.print(k+ " "));
        System.out.println();
        lc145.postorderTraversalIterative(tree2).forEach(k-> System.out.print(k+ " "));
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(0, current.val);
            if (current.left != null) {
                stack.add(current.left);
            }
            if(current.right != null){
                stack.add(current.right);
            }

        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            postorderTraversal(root.left, result);
            postorderTraversal(root.right,result) ;
            result.add(root.val);
        }
    }
}
