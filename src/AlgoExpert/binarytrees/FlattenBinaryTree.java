package AlgoExpert.binarytrees;

public class FlattenBinaryTree {
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
        BinaryTree ten = new BinaryTree(10);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        five.left = seven;
        five.right = eight;

        flattenBinaryTree(root);
    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree leftMost = flattenTree(root)[0];
        return leftMost;

    }

    private static BinaryTree[] flattenTree(BinaryTree node) {
        BinaryTree leftMost;
        BinaryTree rightMost;
        if (node.left == null) {
            leftMost = node;
        }
        else {
            BinaryTree[] leftAndRightMostNodes = flattenTree(node.left);
            connectNodes(leftAndRightMostNodes[1], node);
            leftMost = leftAndRightMostNodes[0];
        }

        if(node.right == null){
            rightMost = node;
        }
        else {
            BinaryTree[] leftAndRightMostNodes = flattenTree(node.right);
            connectNodes(node, leftAndRightMostNodes[0]);
            rightMost =leftAndRightMostNodes[1];
        }
        return new BinaryTree[]{leftMost,rightMost};
    }
    public static void connectNodes(BinaryTree left, BinaryTree right){
        left.right= right;
        right.left = left;
    }


    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
