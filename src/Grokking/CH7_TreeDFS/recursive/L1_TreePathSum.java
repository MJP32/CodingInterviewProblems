package Grokking.CH7_TreeDFS.recursive;


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    TreeNode(int x) {
        val = x;
    }
};

class L1_TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        sum -=root.val;
        if (root.left == null && root.right == null) {
            return sum ==0;
        }

        return hasPath(root.left, sum) || hasPath(root.right, sum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + L1_TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + L1_TreePathSum.hasPath(root, 16));
    }
}
