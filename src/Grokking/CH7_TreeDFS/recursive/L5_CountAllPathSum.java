package Grokking.CH7_TreeDFS.recursive;

import java.util.*;



class L5_CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {


        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);



    }

    private static int countPathsRecursive(TreeNode root, int target, List<Integer> currentPath) {
        if (root == null) {
            return 0;
        }


        currentPath.add(root.val);
        int pathCount = 0;
        int pathSum = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while(pathIterator.hasPrevious()){
            pathSum +=pathIterator.previous();
            if (pathSum == target) {
                pathCount++;
            }
        }


        pathCount +=countPathsRecursive(root.left, target, currentPath);
        pathCount +=countPathsRecursive(root.right, target, currentPath);

        currentPath.remove(currentPath.size()-1);

        return pathCount;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + L5_CountAllPathSum.countPaths(root, 11));
    }
}
