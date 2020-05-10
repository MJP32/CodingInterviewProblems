package Grokking.Ch1_SlidingWindow;


import java.util.HashMap;
import java.util.Map;

class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
    public static int findLength(char[] arr) {
        // TODO: Write your code here

        HashMap<Character, Integer> map = new HashMap();

        int windowStart =0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

            map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd] ,0) +1);

            while(map.size() >2){


                if(map.get(arr[windowStart]) > 0){
                    map.put(arr[windowStart], map.get(arr[windowStart]) -1);
                }

                if(map.get(arr[windowStart]) ==0 ){
                map.remove(arr[windowStart]);

                }
                windowStart++;



            }



        }

        int sum =0;
        for (Map.Entry<Character,Integer> entry :map.entrySet()){
            sum +=entry.getValue();
        }


        return sum;
    }
}