package Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LC904_FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(new LC904_FruitIntoBaskets().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap();
int maxLength =0;
        int windowStart =0;
        for (int windowEnd = 0; windowEnd < tree.length; windowEnd++) {

            map.put(tree[windowEnd], map.getOrDefault(tree[windowEnd] ,0) +1);

            while(map.size() >2){



                map.put(tree[windowStart], map.get(tree[windowStart]) -1);


                if(map.get(tree[windowStart]) ==0 ){
                    map.remove(tree[windowStart]);

                }
                windowStart++;



            }

            maxLength =Math.max(maxLength,windowEnd-windowStart+1);


        }

        /*map.forEach((j, k) -> System.out.println(j+""+ k));
        int sum =0;
        for (Map.Entry<Integer,Integer> entry :map.entrySet()){
            sum +=entry.getValue();
        }*/


        return maxLength;
    }
}
