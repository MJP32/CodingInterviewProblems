package AlgoExpert.binarytrees;

import AlgoExpert.zap.shared.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BranchSums {
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
        two.right=five;
        three.left=six;
        three.right=seven;
        four.left=eight;
        four.right=nine;
        five.left=ten;

        new BranchSums().branchSums(root).forEach(k-> System.out.println(k));



    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer>  result = new ArrayList<>();

        branchSums(0,root, result);
        return result;
    }
    public static void branchSums(int sum, BinaryTree root, List<Integer> result){

        if(root==null)
            return;

        sum +=root.value;
        if(root.left == null && root.right ==null){
            result.add(sum);
            return;
        }

        branchSums(sum, root.left, result);
        branchSums(sum, root.right, result);

    }



}