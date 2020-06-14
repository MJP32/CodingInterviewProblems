package bytebybyte.module2;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printForwardIter(arr);
        printBackwardIter(arr);
        printForwardRecursive(arr, 0);
        printBackWardRecursive(arr, arr.length-1);
    }

    private static void printBackWardRecursive(int[] arr, int i) {
        if (i<0) {
            return;
        }
        System.out.print(arr[i] + " ");
        printBackWardRecursive(arr, i-1);
    }

    private static void printForwardRecursive(int[] arr, int i ) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + " ");
        printForwardRecursive(arr, i+1);
    }

    private static void printForwardIter(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void printBackwardIter(int[] arr) {
        for (int i = arr.length-1; i >=0 ; i--) {
            System.out.print(arr[i] + " ");
        }

    }

}
