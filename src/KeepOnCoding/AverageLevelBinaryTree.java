package KeepOnCoding;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageLevelBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        System.out.println(new AverageLevelBinaryTree().getAverages(root));

    }

    public List<Double> getAverages(TreeNode root){
        List<Double> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){

            double sum =0;
            int count = queue.size();

            TreeNode p;
            for (int i = 0; i < count; i++) {
                p= queue.poll();
                sum +=p.val;
                if(p.left != null)
                    queue.add(p.left);

                if(p.right != null)
                    queue.add(p.right);
            }

            result.add(sum/count);

        }
        return result;

    }
}
