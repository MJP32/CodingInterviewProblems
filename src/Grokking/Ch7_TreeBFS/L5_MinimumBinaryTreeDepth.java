package Grokking.Ch7_TreeBFS;



import java.util.*;

class L5_MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {



        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {

            depth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {


                TreeNode currentNode = queue.poll();

                if(currentNode.left == null && currentNode.right == null){
                    return depth;
                }


                if (currentNode.left!= null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!= null) {
                    queue.offer(currentNode.right);
                }

            }



        }




        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + L5_MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + L5_MinimumBinaryTreeDepth.findDepth(root));
    }
}

