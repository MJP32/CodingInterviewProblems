package Grokking.Ch10_ModifiedBinarySearch;

class BinarySearch {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here

        int i =0;


        int begin =0;
        int end = arr.length-1;


        boolean isAscending = arr[begin] < arr[end];


        while (begin  <= end) {

            int mid  = begin + ( end - begin)/2;

            if(arr[mid] == key){
                return mid;
            }

            if (isAscending) {

                if (key < arr[mid]) {
                    end = mid -1;

                } else {
                    begin = mid +1;

                }
            }
            else{
                if (key > arr[mid]) {
                    end = mid -1;

                } else {
                    begin = mid +1;

                }
            }




        }






        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}