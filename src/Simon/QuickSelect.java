package Simon;

public class QuickSelect {
    public static void main(String[] args) {
        System.out.println( quickSelect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3));
    }
    public static int quickSelect(int[] array, int num){

      return  quickSelectHelper(array, 0, array.length-1, num);


    }

    private static int quickSelectHelper(int[] array, int start, int end, int num) {

        while (true) {
            if (start > end)
                return -1;

            int pivot = start;
            int left = pivot + 1;
            int right = end;

            while (left <= right) {

                if (array[pivot] < array[left] && array[pivot] > array[right]) {
                    swap(array, left, right);

                } if (array[pivot] >= array[left]) {
                    left++;
                } if (array[pivot] <= array[right]) {
                    right--;
                }

            }

            swap(array, pivot, right);
            if(num -1 == right){
                return array[right];
            }
            else if (num-1 <right){

               end =  right - 1;
            }
            else
                start  = right + 1;


        }
    }


    private static void swap(int[] array, int left, int right) {
        int temp= array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
