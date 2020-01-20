package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC230_KSmallestElementinBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.right = new TreeNode(2);


        System.out.println(new LC230_KSmallestElementinBST().kthSmallest(tree, 1));
    }
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);


        result.forEach(l-> System.out.println(l));


        return 1;

    }


    private void inOrderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            inOrderTraversal(root.left, result);
            result.add(root.val);
            inOrderTraversal(root.right,result) ;
        }
    }




}
