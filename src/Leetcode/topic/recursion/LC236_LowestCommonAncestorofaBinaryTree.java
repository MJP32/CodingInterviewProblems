package Leetcode.topic.recursion;

import Leetcode.common.TreeNode;

public class LC236_LowestCommonAncestorofaBinaryTree {
    TreeNode result= null;
        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            TreeNode  one= new TreeNode(1);
            TreeNode  two= new TreeNode(2);
            TreeNode eight = new TreeNode(8);
            TreeNode zero = new TreeNode(0);
            TreeNode four = new TreeNode(4);
            TreeNode seven = new TreeNode(7);
            TreeNode nine = new TreeNode(9);
            TreeNode three = new TreeNode(3);
            TreeNode five = new TreeNode(5);
            TreeNode six = new TreeNode(6);
            root.left =five;
            root.right =one;

            five.left =six;
            five.right =two;

            one.left =zero;
            one.right =eight;
            two.left =seven;
            two.right =four;


            System.out.println(new LC236_LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(root, five,one).val);
        }
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        findLCA(root,p,q);
        return result;


    }
    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q ){
        if (root == null) {
            return false;
        }
        boolean left = findLCA(root.left,p,q);
        boolean right = findLCA(root.right,p,q);
        boolean curr = root ==p || root ==q;
        if ((left && right ) || (left && curr) || (right&&curr)){
            result = root;
        }

        return left ||right ||curr;
    }
}
