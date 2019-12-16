package Leetcode;

import java.util.HashSet;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        LC3_LongestSubstringWithoutRepeatingCharacters lc3 = new LC3_LongestSubstringWithoutRepeatingCharacters();

        System.out.println(lc3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lc3.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        int i =0;
        int j =0;
        int max =0;

        HashSet<Character> set = new HashSet<>();

        while(j< s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;

    }

    public static class FindPeakElement {

        public static void main(String[] args) {

            System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,7,1}));
        }

        public static int findPeakElement(int[] nums) {


            int left =0;
            int right = nums.length -1;

            while(left < right){
                int mid = left + (right -left)/2;
                if(nums[mid]< nums[mid+1]){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }
            return left;
        }
    }
}
