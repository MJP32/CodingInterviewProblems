package Leetcode.easy;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC637_AverageLevelsInBinaryTree {
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        new LC637_AverageLevelsInBinaryTree().averageOfLevels(tree).forEach(k-> System.out.println(k));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode p;

        while(!queue.isEmpty()){

        double sum =0;
        int count = queue.size();

            for (int i = 0; i < count; i++) {

                p = queue.poll();

                sum +=p.val;
                if (p.left != null) {
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }


            result.add(sum/count);

        }



        return result;
    }
}
