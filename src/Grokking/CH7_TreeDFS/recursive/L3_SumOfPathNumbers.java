package Grokking.CH7_TreeDFS.recursive;


class L3_SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
         return findSumOfPathNumbersRecursive(root, 0);
    }

    private static int findSumOfPathNumbersRecursive(TreeNode root, int total) {

        if (root == null) {
            return 0;
        }

        total = 10 * total + root.val;

        if (root.left == null && root.right == null) {
            return total;
        }

        return findSumOfPathNumbersRecursive(root.left, total) +
                findSumOfPathNumbersRecursive(root.right, total);



    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + L3_SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}

