package AlgoExpert.binarytrees;

import AlgoExpert.zap.shared.BinaryTree;

class MaxPathSum {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        //BinaryTree ten = new BinaryTree(10);

        root.left = two;
        root.right = three;
        two.left = four;
        two.right=five;
        three.left=six;
        three.right=seven;
        four.left=eight;
        four.right=nine;
        //five.left=ten;

        System.out.println(new MaxPathSum().getClass().getName() +" " +maxPathSum(root));

    }
    public static Integer maxPathSum(BinaryTree tree) {
        // Write your code here.

        int max = Integer.MIN_VALUE;
        max =maxPathSumHelper(tree, max);
        return max;
    }
    public static  int maxPathSumHelper(BinaryTree tree, int max){
        if(tree == null){
            return max;
        }
        return maxPathSumHelper(tree.left , max + tree.left.value) + maxPathSumHelper(tree.right, max + tree
                .right.value);

    }

}
