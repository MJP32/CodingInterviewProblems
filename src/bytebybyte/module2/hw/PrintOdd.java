package bytebybyte.module2.hw;

public class PrintOdd {
    public static void main(String[] args) {
        printOdd(new int[]{1,2,3,4,5,6,7,8,9,10,11});
    }
    static void printOdd(int[] arr){

        printOdd(arr, 0);
    }

    private static void printOdd(int[] arr, int i) {
        if(i >= arr.length){
            return;
        }
        System.out.println(arr[i]);
        printOdd(arr, i+2);
    }
}
