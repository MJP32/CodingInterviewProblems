package Grokking.CH7_TreeDFS.recursive;

import java.util.*;



class L2_FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root,sum, currentPath, allPaths);






        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {

        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        }
        else{
            findPathsRecursive(root.left, sum - root.val, currentPath,allPaths);
            findPathsRecursive(root.right, sum - root.val, currentPath,allPaths);
        }

        currentPath.remove(currentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = L2_FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
