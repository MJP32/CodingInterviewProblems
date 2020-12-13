package AlgoExpert.binarytrees.MaxDiameter;

public class BinaryTreeMaxDiameter {


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


        root.left = three;
        root.right = two;

        three.left = seven;
        three.right = four;

        four.right = five;
        five.right = six;
        seven.left = eight;
        eight.right = nine;

        System.out.println(new BinaryTreeMaxDiameter().binaryTreeDiameter(root));
    }


    public int binaryTreeDiameter(BinaryTree tree) {

        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null)
            return new TreeInfo(0, 0);

        TreeInfo leftTreeData = getTreeInfo(tree.left);
        TreeInfo rightTreeData = getTreeInfo(tree.right);
        int longestPathThroughRoot = leftTreeData.height + rightTreeData.height;
        int maxDiameterSoFar = Math.max(leftTreeData.diameter, rightTreeData.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeData.height, rightTreeData.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }
}

class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
        this.value = value;
    }
}

class TreeInfo {
    int diameter;
    int height;

    public TreeInfo(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }

}
