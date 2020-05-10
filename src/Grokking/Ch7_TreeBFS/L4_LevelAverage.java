package Grokking.Ch7_TreeBFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class L4_LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();


            double sum =0;
            for (int i = 0; i < levelSize; i++) {


                TreeNode currentNode = queue.poll();

                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);

                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }


            }

            result.add(sum/levelSize);



        }





        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = L4_LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
