package AlgoExpert.binarysearchtree;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {
    public static void main(String[] args) {
        minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
    }

    public static BST minHeightBst(List<Integer> array) {
        return createTree(array, null, 0, array.size() - 1);
    }

    private static BST createTree(List<Integer> array, BST bst, int startIdx, int endIdx) {

        if (endIdx < startIdx) {
            return null;
        }

        int midIdx = (startIdx + endIdx) / 2;
        int valueToAdd = array.get(midIdx);

        if (bst == null) {
            bst = new BST(valueToAdd);
        } else {
            bst.insert(valueToAdd);
        }

        createTree(array, bst, startIdx, midIdx - 1);
        createTree(array, bst, midIdx + 1, endIdx);

        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
