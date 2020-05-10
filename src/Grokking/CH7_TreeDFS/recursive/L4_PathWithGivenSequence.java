package Grokking.CH7_TreeDFS.recursive;


class L4_PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {

        if (root == null) {
            return sequence.length ==0;
        }

        return findPathRecursive(root, sequence, 0);

    }

    private static boolean findPathRecursive(TreeNode root, int[] sequence, int i) {

        if (root == null) {
            return false;
        }

        if (root.val != sequence[i] || i >= sequence.length) {
            return false;
        }

        if (root.left == null && root.right ==null&& i ==sequence.length-1) {
            return true;
        }
        return findPathRecursive(root.left, sequence, i+1) ||findPathRecursive(root.right, sequence, i+1);



    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + L4_PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + L4_PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}

