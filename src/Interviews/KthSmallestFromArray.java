package Interviews;

import java.util.PriorityQueue;

public class KthSmallestFromArray {
    public static void main(String[] args) {



        int[] arr = {8,5,2,9,7,6,3};
        System.out.println(min2(arr));
        System.out.println(kthSmallestHeap(arr, 2));
        System.out.println(kthSmallestQuickSelect(arr, 2));
    }

    private static int kthSmallestQuickSelect(int[] arr, int k) {

        return quickSelect(arr, 0, arr.length-1, k-1);
    }

    private static int quickSelect(int[] arr, int startIdx, int endIdx, int position) {

        while(true){


            if(startIdx> endIdx)
                return -1;
            int pivorIdx = startIdx;
            int leftIdx = pivorIdx+1;
            int rightIdx = endIdx;

            while(leftIdx <=rightIdx) {

                if (arr[leftIdx] > arr[pivorIdx] && arr[rightIdx] < arr[pivorIdx]) {
                    swap(arr, rightIdx, leftIdx);

                }
                if (arr[leftIdx] <= arr[pivorIdx]) {
                    leftIdx++;
                }
                if (arr[rightIdx] >= arr[pivorIdx]) {
                    rightIdx--;
                }
            }

            swap(arr, rightIdx, pivorIdx);


            if(rightIdx == position){
                return arr[rightIdx];
            }
            else if(rightIdx < position){
                startIdx = rightIdx+1;
            }
            else{
                endIdx = rightIdx-1;
            }



        }


    }

    private static void swap(int[] arr, int rightIdx, int pivorIdx) {
        int temp = arr[pivorIdx];
        arr[pivorIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
    }


    private static int kthSmallestHeap(int[] arr, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);

        for(int i : arr){
            minHeap.add(i);
        }

        while(k-1> 0){
            minHeap.poll();
            k--;
        }

        return minHeap.peek();

    }

    private static int min2(int[] arr) {
        int min = arr[0];
        int min2 = arr[1];

        for(int i =0; i < arr.length;i++){
            if(arr[i]< min){
                min2= min;
                min = arr[i];

            }
            else if(arr[i] < min2){
                min2 = arr[i];
            }
        }
        return min2;
    }

}
