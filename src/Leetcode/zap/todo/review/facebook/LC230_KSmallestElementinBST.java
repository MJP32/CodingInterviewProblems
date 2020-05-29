package Leetcode.zap.todo.review.facebook;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC230_KSmallestElementinBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.right = new TreeNode(2);


                    /*
                               1
                           2         8
                        4    5    10   13


                     */


        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(8);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(10);
        tree1.right.right = new TreeNode(13);



        System.out.println(new LC230_KSmallestElementinBST().kthSmallest(tree1, 5));
        System.out.println(new LC230_KSmallestElementinBST().kthSmallestLC(tree1, 5));
        System.out.println(new LC230_KSmallestElementinBST().kthSmallestLCStack(tree1, 5));
    }
/*
Time complexity : O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H + kH+k elements, since before starting to pop out one has to go down to a leaf. This results in \mathcal{O}(\log N + k)O(logN+k) for the balanced tree and \mathcal{O}(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
Space complexity : O(H+k), the same as for time complexity, \mathcal{O}(N + k)O(N+k) in the worst case, and \mathcal{O}(\log N + k)O(logN+k) in the average case.

 */
    public int kthSmallestLCStack(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }




    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list =  new ArrayList<Integer>();
        inOrderTraversal(root, list, k);
        return list.get(k-1);

    }


    private void inOrderTraversal(TreeNode root, List<Integer> list, int k ) {

        if(root == null){
            return ;
        }


        inOrderTraversal(root.left,list, k ) ;
        list.add(root.val);
        inOrderTraversal(root.right,list, k ) ;
    }






    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallestLC(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

}
