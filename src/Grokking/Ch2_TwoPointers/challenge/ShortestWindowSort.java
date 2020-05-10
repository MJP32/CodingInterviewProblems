package Grokking.Ch2_TwoPointers.challenge;

public class ShortestWindowSort {

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }

    public static int sort(int[] arr) {
        // TODO: Write your code here
        int left =0;
        int right =arr.length-1;



        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1] ){
                left = i-1;
                break;
            }
        }

        for (int i = arr.length-1; i >0 ; i--) {
            if(arr[i-1] >arr[i]){
                right =i;
                break;
            }
        }

        right = getRight(right, arr);


        //already sorted
        if (right == arr.length-1 && left == 0) {
            return 0;
        }

        //System.out.println(left +" "+ right );
        return right-left;
    }

    private static int getRight(int start, int[] arr) {

        return 1;
    }
}
