package Grokking.Ch7_TreeBFS;

import java.util.*;



class L3_ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        boolean flag = true;
        while (!queue.isEmpty()) {

            List<Integer> currentList = new ArrayList<>(queue.size());

            int levelSize = queue.size();
            int curr =0;

            for (int i = 0; i < levelSize; i++) {


                TreeNode currentNode = queue.poll();
                if (flag) {
                    currentList.add(currentNode.val);
                }
                else{
                    currentList.add(0,currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }


            }

            result.add(currentList);

            flag = !flag;



        }






        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = L3_ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
