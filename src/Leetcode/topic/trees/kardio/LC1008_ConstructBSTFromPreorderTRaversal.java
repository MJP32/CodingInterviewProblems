package Leetcode.topic.trees.kardio;

import Leetcode.common.TreeNode;

public class LC1008_ConstructBSTFromPreorderTRaversal {
    public static void main(String[] args) {

    }
    public int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode construct(int[] preorder, int min, int max){
        if(index >= preorder.length) return null;

        TreeNode node = null;

        if(preorder[index] > min && preorder[index] < max){
            node = new TreeNode(preorder[index]);
            index++;

            node.left = construct(preorder, min, node.val);
            node.right = construct(preorder, node.val, max);
        }

        return node;
    }



}
