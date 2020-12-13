package Simon;

public class SecondSmallest {
    public static void main(String[] args) {

        System.out.println( secondSmallest(new int[]{8, 5, 2, 9, 7, 6, 3}, 2));
    }

    public static int secondSmallest(int[] array, int idxToFind){
        int smallest, second;
        if(array.length < 2){
            return -1;
        }

        if(array[0] < array[1]){
            smallest = array[0];
            second = array[1];
        }
        else{
            smallest = array[1];
            second = array[0];
        }


        for(int i =1; i < array.length;i++){
            int num = array[i];

            if(num < smallest){
                second = smallest;
                smallest = num;
            }
            else if(num < second){
                second = num;
            }



        }



        return second;
    }
}
