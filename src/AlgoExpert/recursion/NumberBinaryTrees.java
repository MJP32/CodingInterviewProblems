package AlgoExpert.recursion;

public class NumberBinaryTrees {
    public static void main(String[] args) {

    }
    public static int numberOfBinaryTreeTopologies(int n) {
        if(n ==0){
            return 1;
        }
        int numberOfTrees =0;

        for(int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++){
            int rightTreeSize = n -1 -leftTreeSize;
            int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
            int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
            numberOfTrees += numberOfLeftTrees + numberOfRightTrees;
        }



        return numberOfTrees;
    }
}
