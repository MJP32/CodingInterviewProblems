package Amazon;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8, 30};
        getInterval(arr).forEach(System.out::print);

    }
    public static List<List<Integer>> getInterval(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }
        int i =0;
        while( i< nums.length){
            List<Integer> interval = new ArrayList<>();
            int beg = nums[i];
set.remove(beg);

            while(set.contains(--beg)){
               set.remove(beg);

            }
            interval.add(beg+1);
            int end = nums[i];
            while(set.contains(++end)){
                set.remove(end);
            }
            interval.add(end-1);
            nums[i]= Integer.MIN_VALUE;

            result.add(Arrays.asList(beg+1,end-1 ));

            i++;
        }



        return result;
    }

}
