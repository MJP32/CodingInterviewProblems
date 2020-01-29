package Leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1207_UniqueNumberOcccurrences {
    public static void main(String[] args) {

        LC1207_UniqueNumberOcccurrences lc1207 = new  LC1207_UniqueNumberOcccurrences();
        System.out.println(lc1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));

    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0;i< arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1 );
        }


        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            //System.out.println(entry.getKey() + " " + entry.getValue());
            set.add(entry.getValue());
        }


        return map.size() ==set.size();

    }

}
