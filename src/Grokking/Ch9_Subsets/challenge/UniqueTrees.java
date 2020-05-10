package Grokking.Ch9_Subsets.challenge;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        //

        if (n<=0) {
            return new ArrayList<TreeNode>();
        }


        return findUniqueTreesRecursive(1, n);
    }

    private static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start >end) {
            result.add(null);
            return result;
        }

        for (int i = start; i < end; i++) {

            List<TreeNode> leftSubTree = findUniqueTreesRecursive(start, i+1);
            List<TreeNode> rightSubTree = findUniqueTreesRecursive(i+1, end);

            for (TreeNode leftTree : leftSubTree) {
                for (TreeNode rightTree: rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);

                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
