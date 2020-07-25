package Pramp;

public class ArrayIndexAndElementEquality {
    public static void main(String[] args) {
       /*
       function indexEqualsValueSearch(arr):
            start = 0
            end = arr.length - 1

            while (start <= end):
                i = round((start+end)/2)
                if (arr[i] - i < 0):
                    start = i+1
                else if (arr[i] - i == 0) and ((i == 0) or (arr[i-1] - (i-1) < 0)):
                    return i
                else:
                    end = i-1

            return -1

        */
    }
    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here


        if(arr.length ==0){
            return -1;
        }

        int mid = 0;

        int high =arr.length -1;
        int low = 0;
        int result = -1;

        while(low <= high){
            mid = (low+ high)/2;
            if(arr[mid] == mid){

                result = mid;
                low = mid +1;
                //return mid;


            }
            else if (arr[mid] < mid){

                low = mid +1;

            }
            else{
                high = mid-1;

            }

        }
        return result;

    }




    }
