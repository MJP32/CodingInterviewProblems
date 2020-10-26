package Interviews.InterviewIO;

import java.util.HashSet;
import java.util.Set;

public class IntervalsFromArray {
    public static void main(String[] args) {
        /*
        Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

        Your algorithm should run in O(n) complexity.

        Example:

        Input: [100, 4, 200, 1, 3, 2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
         */

        System.out.println(new IntervalsFromArray().getIntervals(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(countUnique(new int[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, 8));
    }
    static int countUnique(int arr[], int n)
    {

        // Set to store unique pairs
        Set<Pair> s = new HashSet<>();

        // Make all possible pairs
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                s.add(new Pair(arr[i], arr[j]));

        // Return the size of the set
        return s.size();
    }
    public Set<Pair> getIntervals(int[] nums){
        Set<Pair> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        for(int i : nums){

            int left = i;
            int right = i;
            while(set.contains(left)){
                left--;
            }
            while(set.contains(right)){
                right++;
            }


                result.add(new Pair(left+1,right-1));


        }

        for(Pair p: result){

            System.out.println(p.left + " " + p.right);
        }
        return result;

    }

    public int longestConsecutive(int i, Set<Integer> set) {


        int max =0;



            int left =i -1;
            int right = i +1;
            int currLength =1;

            while(set.contains(left)){
                currLength++;
                left--;
            }

            while(set.contains(right)){
                currLength++;
                right++;
            }


            if(max < currLength){
                max = currLength;
            }





        return max;

    }
}
