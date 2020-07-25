package Leetcode.topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1229_MeetingScheduler {
    public static void main(String[] args) {
        new LC1229_MeetingScheduler().minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,
                15}, {60,70}}, 8 ).forEach(k-> System.out.println(k));
    }
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        if(slots1==null || slots2==null || slots1.length ==0 || slots2.length==0)
            return new ArrayList<Integer>();

        Arrays.sort(slots1, (i1, i2) -> (i1[0] == i2[0])? i1[1] - i2[1] : i1[0] - i2[0]);
        Arrays.sort(slots2, (i1, i2) -> (i1[0] == i2[0])? i1[1] - i2[1] : i1[0] - i2[0]);
        int i = 0;
        int j = 0;
        while(i<=slots1.length-1 && j <=slots2.length-1)
        {   //check if availability overlaps
            if(!(slots1[i][1] < slots2[j][0] || slots2[j][1] < slots1[i][0]))
            {
                //Find overlaping time
                int startOverlap = Math.max(slots1[i][0], slots2[j][0]);
                int endOverlap = Math.min(slots1[i][1], slots2[j][1]);
                if(endOverlap - startOverlap >= duration)
                {
                    return Arrays.asList(startOverlap, startOverlap+duration);
                }
            }

            //Move pointers for one who is ending first
            if(slots1[i][1] < slots2[j][1])
                i++;
            else
                j++;
        }

        return new ArrayList<Integer>();
    }
    public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
        if(slots1==null || slots2==null || slots1.length ==0 || slots2.length==0)
            return new ArrayList<Integer>();

        Arrays.sort(slots1, (i1, i2) -> (i1[0] == i2[0])? i1[1] - i2[1] : i1[0] - i2[0]);
        Arrays.sort(slots2, (i1, i2) -> (i1[0] == i2[0])? i1[1] - i2[1] : i1[0] - i2[0]);
        int i = 0;
        int j = 0;
        while(i<=slots1.length-1 && j <=slots2.length-1)
        {   //check if availability overlaps
            if(!(slots1[i][1] < slots2[j][0] || slots2[j][1] < slots1[i][0]))
            {
                //Find overlaping time
                int startOverlap = Math.max(slots1[i][0], slots2[j][0]);
                int endOverlap = Math.min(slots1[i][1], slots2[j][1]);
                if(endOverlap - startOverlap >= duration)
                {
                    return Arrays.asList(startOverlap, startOverlap+duration);
                }
            }

            //Move pointers for one who is ending first
            if(slots1[i][1] < slots2[j][1])
                i++;
            else
                j++;
        }

        return new ArrayList<Integer>();
    }
}
