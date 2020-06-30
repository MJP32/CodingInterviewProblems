package AlgoExpert.arrays;



import java.util.*;

public class LargestRange {

    public static void main(String[] args) {
        System.out.println("->");
        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})));
        System.out.println(Arrays.toString(largestRange(new int[]{4, 2, 1, 3, 6})));
    }
    public static int[] largestRange(int[] array) {
        // Write your code here.

        int[] ans = new int[2];


        //HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        Set<Integer> set = new HashSet<>();
        for (Integer i: array){
            //map.put(i, true);
            set.add(i);
        }

        //map.forEach((key, value) -> System.out.println(key + " : " + value));

        int maxLength = -1;

        for (int num: array){


//            if(!set.contains(num))
//                continue;;

            int currLength =1;
            int left = num -1;
            int right = num +1;


            //set.put(num, false);

            while (set.contains(left)) {
                //map.put(left, false);
                currLength++;
                left--;
            }

            while(set.contains(right)){
                //map.put(right, false);
                currLength++;
                right++;
            }

            if(maxLength <currLength){
                maxLength = currLength;
                ans[0]=left+1;
                ans[1]=right-1;
            }
        }
        return ans;
    }
}
