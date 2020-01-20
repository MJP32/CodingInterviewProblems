package Leetcode.topic.trees;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC515_FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(3);
        //tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(9);


        LC515_FindLargestValueInEachTreeRow lc515 = new LC515_FindLargestValueInEachTreeRow();
        System.out.println(lc515.largestValues(tree));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
           return result;
        }


        dfs(root, result, 0);
        //result.add(root.val);







        return result;
    }


    private void dfs(TreeNode root, List<Integer> result, int level){

        if(root == null)
            return;


        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level, Math.max(result.get(level), root.val));
        }

        dfs(root.left, result, level++);
        dfs(root.right, result, level++);

    }

}
