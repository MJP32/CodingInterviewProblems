package Grokking.Ch4_MergeIntervals;



import Grokking.Ch4_MergeIntervals.Interval;

import java.util.*;

public class Ch4_1_MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));


        List<Interval> mergedIntervals = new LinkedList<Interval>();

        Iterator<Interval> iter = intervals.iterator();
        Interval interval = iter.next();

        int start = interval.start;
        int end = interval.end;
        while (iter.hasNext()) {
            interval = iter.next();
            if (interval.start <= end) {
                end = Math.max(interval.end,end);
            }
            else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }


        }



        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : Ch4_1_MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : Ch4_1_MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : Ch4_1_MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
