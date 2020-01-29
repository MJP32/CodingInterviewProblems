package Interviews;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        //getMostFrequentNumber(new int []{1,2,3,3,1 , 5, 5, 5, 5,5, 5, 5, 5, 5, 5, 5, 6,5 ,5});

        get2ValuesSumToK(new int []{0, 0, 1,2,3,3,1 , 5, 5, 5, 2, 2},  4);
        }

    private static void get2ValuesSumToK(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);


        int start =0;
        int end = (nums.length-1);

        while(start < end){


            int sum = nums[start] + nums[end];
            if(sum == target){
                list.add(nums[start]);
                list.add(nums[end]);

                start++;
                end--;
            }
            else if (sum > target){
                end -=1;
            }
            else{
                start +=1;
            }



        }

        System.out.println(list.toString());
//        list.forEach(k-> System.out.println(k));



    }


    private static void getMostFrequentNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }


        System.out.println(maxValueInMap);


        map.forEach((key, value) -> System.out.println(key + ":" + value));


    }





}
