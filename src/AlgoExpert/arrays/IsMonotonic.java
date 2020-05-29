package AlgoExpert.arrays;

public class IsMonotonic {
    public static void main(String[] args) {
        //System.out.println(isMonotonic(new int[]{1,2,3,4}));
        System.out.println(isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }
    public static boolean isMonotonic(int[] array) {
        boolean inc = true;
        boolean dec = true;
        for(int i =0; i < array.length-1;i++){
            if(array[i] < array[i+1] ){
                dec = false;
            }
        }
        for(int i =array.length-1;i>0;i--){
            if(array[i] <= array[i-1]){
                inc=false;
            }
        }

        return inc || dec;
    }
}
