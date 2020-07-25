package Pramp;

public class ShiftedArraySearch {
    static int shiftedArrSearch(int[] shiftArr, int k) {
        if(shiftArr == null || shiftArr.length ==0 )
            return -1;


        int left =0;
        int right = shiftArr.length -1;
        while(left< right){
            int midpoint = left +(right - left)/2;
            if(shiftArr[midpoint] > shiftArr[right]){
                left = midpoint+1;
            }
            else{
                right = midpoint;
            }

        }

        int pivot = left;
        left =0;
        right =shiftArr.length-1;
        if(k >= shiftArr[pivot] && k <= shiftArr[right]) {
            left = pivot;
        }
        else{
            right =pivot-1;
        }

        while(left <= right){
            int midpoint = left+(right-left);
            if(shiftArr[midpoint] == k){
                return midpoint;
            }
            else if(shiftArr[midpoint] < k){
                left = midpoint +1;
            }
            else{
                right = midpoint -1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(shiftedArrSearch(new int[]{9,12,17,2,4,5}, 17));
//        System.out.println(shiftedArrSearch(new int[]{0,1,2,3,4,5}, 1));
//        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 2));
    }
}
