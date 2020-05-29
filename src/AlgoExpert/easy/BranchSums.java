package AlgoExpert.easy;

import AlgoExpert.shared.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {


    public static List<Integer> branchSums(BinaryTree root) {

List<Integer> list = new ArrayList<Integer>();

        inOrder(root, 0, list );


        return list;
    }

    private static void inOrder(BinaryTree root, int sum, List<Integer> list) {
        if (root  == null ) {
            return;

        }
        if (root.left == null && root.right == null) {
            list.add(sum + root.value);
            return;
        }
        inOrder(root.left, sum + root.value,list );
        inOrder(root.right, sum + root.value,list );



    }

    public static void main(String[] args) {
        BinaryTree tree  = new BinaryTree(1 );
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.left = new BinaryTree(10);

        branchSums(tree).forEach(k-> System.out.println(k));

    }

}
