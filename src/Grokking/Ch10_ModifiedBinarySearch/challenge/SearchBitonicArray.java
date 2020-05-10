package Grokking.Ch10_ModifiedBinarySearch.challenge;

class SearchBitonicArray {

    public static int search(int[] arr, int key) {





        return 0;
    }

    private static int findMax(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start < end) {

            mid = start + (end - start)/2;

            if (arr[mid] < arr[mid +1]) {
                start = mid +1;
            }
            else{
                end = mid;
            }


        }


        return start;

    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}