package bytebybyte.module2;

public class SumArray {
    public static void main(String[] args) {
        System.out.println(sumArray(new int[]{1,2,3,4}));
    }

    private static int sumArray(int[] arr) {
        return sumArray(arr, 0);
    }

    private static int sumArray(int[] arr, int i) {
        if(i ==arr.length){
            return 0;
        }
        return arr[i] + sumArray(arr, i+1);
    }
}
