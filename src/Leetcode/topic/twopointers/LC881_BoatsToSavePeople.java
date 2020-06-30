package Leetcode.topic.twopointers;

import java.util.Arrays;

public class LC881_BoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(new LC881_BoatsToSavePeople().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int numBoats =0;

        int i = 0, j = people.length-1;

        while (i <= j) {
            if(people[i] + people[j] <= limit){
                j--;
                i++;
            }
            else {
                j--;
            }
           numBoats++;

        }


        return numBoats;
    }

}
