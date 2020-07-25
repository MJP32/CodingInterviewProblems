package Leetcode.topic.stg;

import java.util.ArrayList;
import java.util.List;

public class LC759_EmployeeFreeTime {
    public static void main(String[] args) {

        List<List<Interval>> schedule = new ArrayList<>();

        List<Interval> interval1 = new ArrayList<>();
        List<Interval> interval2 = new ArrayList<>();
        List<Interval> interval3= new ArrayList<>();
        interval1.add(new Interval(1,3));
        interval1.add(new Interval(6,7));
        interval2.add(new Interval(2,4));
        interval3.add(new Interval(2,5));
        interval3.add(new Interval(9,12));

        schedule.add(interval1);
        schedule.add(interval2);
        schedule.add(interval3);

        new LC759_EmployeeFreeTime().employeeFreeTime(schedule).forEach(k-> System.out.println(k));

    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<List<Interval>> mschedule = new ArrayList<>();
        List<Interval> mergedIntervals = new ArrayList<>();
        List<Interval> firstInterval = new ArrayList<>();

        firstInterval =schedule.get(0);
        for (int i = 1; i < schedule.size();i++) {
            List<Interval> nextIntervals = new ArrayList<>();
            nextIntervals = schedule.get(i);


            firstInterval = mergeCalendars(firstInterval, nextIntervals);



        }

        List<Interval> combinedList = flattenCalenedars(firstInterval);



        //combinedList.forEach(k-> System.out.println(k));



        return getFreeTime(combinedList);
    }

    private List<Interval> getFreeTime(List<Interval> combinedList) {
        List<Interval> freeTime = new ArrayList<>();


        for (int i = 1; i < combinedList.size(); i++) {

            int end  = combinedList.get(i-1).end;
            int nextStart  = combinedList.get(i).start;
            //check for free time
            if(end< nextStart){
                freeTime.add(new Interval(end, nextStart));
            }

        }

        return freeTime;
    }


    private static List<Interval> flattenCalenedars(List<Interval> calendar) {
        List<Interval> flattened = new ArrayList<>();

        flattened.add(calendar.get(0));

        for (int i = 1; i < calendar.size() ; i++) {

            Interval currentMeeting = calendar.get(i);
            Interval prevMeeting = flattened.get(flattened.size()-1);
            if(prevMeeting.end >= currentMeeting.start){
                Interval newPreviousMeeting = new Interval(prevMeeting.start, Math.max(prevMeeting.end, currentMeeting.end));
                flattened.set(flattened.size()-1, newPreviousMeeting);
            }
            else{
                flattened.add(currentMeeting);
            }

        }


        return flattened;
    }

    private static List<Interval> mergeCalendars(List<Interval> updatedCaleandr1, List<Interval> updatedCaleandr2) {
        List<Interval> merged = new ArrayList<>();

        int i =0;
        int j =0;

        while(i < updatedCaleandr1.size() && j < updatedCaleandr2.size()){
            Interval meeting1 = updatedCaleandr1.get(i);
            Interval  meeting2 = updatedCaleandr2.get(j);
            if(meeting1.start < meeting2.start){
                merged.add(meeting1);
                i++;
            }
            else{
                merged.add(meeting2);
                j++;
            }
        }

        while(i < updatedCaleandr1.size()){
            merged.add(updatedCaleandr1.get(i++));
        }
        while(j < updatedCaleandr2.size()){
            merged.add(updatedCaleandr2.get(j++));
        }

        return merged;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
