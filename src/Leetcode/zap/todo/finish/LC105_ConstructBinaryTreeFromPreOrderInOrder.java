package Leetcode.zap.todo.finish;

import Leetcode.common.TreeNode;

public class LC105_ConstructBinaryTreeFromPreOrderInOrder {
    public static void main(String[] args) {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(0,0, inorder.length-1, preorder, inorder);

    }

    private TreeNode helper(int presStart, int inStart, int inEnd, int[] preorder, int[] inorder) {


        if(presStart > preorder.length-1 || inStart> inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[presStart]);

        int inIndex =0;
        for (int i = inStart; i < inEnd; i++) {
            if(root.val == inorder[i]){
                inIndex =i;
            }

        }

        root.left = helper(presStart +1, inStart, inIndex-1,preorder,inorder);

        root.right = helper(presStart +inIndex-inStart+1,  inIndex+1, inEnd,preorder,inorder);
        return root;
    }
}
