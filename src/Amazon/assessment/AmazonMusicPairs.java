package Amazon.assessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmazonMusicPairs {
    public static void main(String[] args) {
        int[] nums1 = { 37, 23, 60 };
        int[] nums2 = { 10, 50, 90, 30 };
        int[] nums3 = { 30, 20, 150, 100, 40 };
        int[] nums4 = { 60, 60, 60 };
        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
        System.out.println(solve(nums3));
        System.out.println(solve(nums4));
    }
    private static int solve(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int numOfPair =0;
        int startSong = 0;
        int endSong = nums.length-1;
        while(startSong < endSong){
            int startData = nums[startSong];
            int endData = nums[endSong];
            int sum = startData+endData;
            if(sum == 60){
                startSong++;
                endSong--;
                numOfPair++;
            } else if(sum > 60){
                endSong--;
            } else if(sum < 60){
                startSong--;
            }
        }
        return numOfPair;
    }
    private static int solve2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums) {
            n = n%60;
            int key = 60 - n;
            if(map.containsKey(key == 60 ? 0 : key))
                res += map.get(key == 60 ? 0 : key);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
        return res;
    }
}
