package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC94_BTInorgerTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);


        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {

        if(root != null){
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right,result) ;
        }
    }
}
