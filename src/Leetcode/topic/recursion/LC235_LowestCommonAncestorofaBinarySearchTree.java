package Leetcode.topic.recursion;

import Leetcode.common.TreeNode;

public class LC235_LowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args) {
     TreeNode root = new TreeNode(6);
     TreeNode  two= new TreeNode(2);
     TreeNode eight = new TreeNode(8);
     TreeNode zero = new TreeNode(0);
     TreeNode four = new TreeNode(4);
     TreeNode seven = new TreeNode(7);
     TreeNode nine = new TreeNode(9);
     TreeNode three = new TreeNode(3);
     TreeNode five = new TreeNode(5);
     root.left =two;
     root.right =eight;
     two.left =zero;
     two.right =four;
     eight.left =seven;
     eight.right =nine;
     four.left =three;
     four.right =five;


        System.out.println(new LC235_LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(root, two,eight).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int parentVal = root.val;
        int pVal  = p.val;
        int qVal = q.val;

        if (pVal >parentVal && qVal> parentVal) {
            //right
            return lowestCommonAncestor(root.right,q,p);
        }
        else if (pVal <parentVal && qVal< parentVal) {
            //left
            return lowestCommonAncestor(root.left,q,p);
        }

        else{
            return root;
        }
    }
}
