package Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC442_DuplicatesInArray {
    public static void main(String[] args) {

        LC442_DuplicatesInArray lc442 = new LC442_DuplicatesInArray();
        lc442.findDuplicates(new int[]{4,3,2,7,8,2,3,1}).forEach(k-> System.out.println(k));
    }
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {


            if(map.containsKey(nums[i])){
                results.add(nums[i]);
            }
            else{
                map.put(nums[i], 1);
            }


        }


        return results;
    }
}
