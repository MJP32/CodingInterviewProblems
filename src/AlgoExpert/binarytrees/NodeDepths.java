package AlgoExpert.binarytrees;

import AlgoExpert.zap.shared.BinaryTree;

class NodeDepths {
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

        System.out.println(new NodeDepths().getClass().getName() +" " +nodeDepths(root));

    }
    public static int nodeDepths(BinaryTree root) {
            return nodeDepthsHelper(root, 0);
    }

    public static int nodeDepthsHelper(BinaryTree root, int depth){
        if(root == null){
            return 0;
        }
        return depth + nodeDepthsHelper(root.left, depth+1) + nodeDepthsHelper(root.right, depth +1);
    }

}
