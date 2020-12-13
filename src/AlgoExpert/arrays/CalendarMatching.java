package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarMatching {
    public static void main(String[] args) {
        List<StringMeeting> calendar1= Arrays.asList(new StringMeeting("9:00", "10:30"), new StringMeeting("12:00",
                        "13:00"), new StringMeeting("16:00", "18:00"));
        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");
        List<StringMeeting> calendar2 =Arrays.asList(new StringMeeting("10:00", "11:30"), new StringMeeting("12:30",
                "14:30"), new StringMeeting("14:30", "15:00"), new StringMeeting("16:00", "17:00"));
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");
        int meetingDuration = 30;

        calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration).forEach(k-> System.out
                .println(k.toString()));
    }


    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.


        List<Meeting> updatedCaleandr1 = updateCalendar(calendar1, dailyBounds1);
        System.out.println(updatedCaleandr1);
        List<Meeting> updatedCaleandr2 = updateCalendar(calendar2, dailyBounds2);



        List<Meeting> mergedCalendar = mergeCalendars(updatedCaleandr1, updatedCaleandr2);
        mergedCalendar.forEach(k-> System.out.println(k.toString()));
        List<Meeting> flattencalendr = flattenCalenedars(mergedCalendar);
//        flattencalendr.forEach(k-> System.out.println(k.toString()));
        System.out.println();

        return getMatchingAvailabilities(flattencalendr, meetingDuration);
    }

    private static List<StringMeeting> getMatchingAvailabilities(List<Meeting> calendar, int meetingDuration) {

        List<Meeting> matchingAvailabilities = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i-1).end;
            int end = calendar.get(i).start;

            int duration  = end- start;
            if(duration >= meetingDuration){
                matchingAvailabilities.add(new Meeting(start, end));
            }
        }


        List<StringMeeting> matchingAvailibitiesInHours = new ArrayList<>();
        for (int i = 0; i <matchingAvailabilities.size(); i++) {
            matchingAvailibitiesInHours.add(new StringMeeting(minutesToTime(matchingAvailabilities.get(i).start),
                    minutesToTime(matchingAvailabilities.get(i).end)));
        }


        return matchingAvailibitiesInHours;
    }

    private static String minutesToTime(int minutes) {
        int hours = minutes/60;
        int mins = minutes%60;

        String hoursString = Integer.toString(hours);
        String minsString  = mins <10 ? "0" + Integer.toString(mins) : Integer.toString(mins);

        return hoursString + ":" + minsString;

    }

    private static List<Meeting> flattenCalenedars(List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<>();

        flattened.add(calendar.get(0));

        for (int i = 1; i < calendar.size() ; i++) {

            Meeting currentMeeting = calendar.get(i);
            Meeting prevMeeting = flattened.get(flattened.size()-1);
            if(prevMeeting.end >= currentMeeting.start){
                Meeting newPreviousMeeting = new Meeting(prevMeeting.start, Math.max(prevMeeting.end, currentMeeting
                        .end));
                flattened.set(flattened.size()-1, newPreviousMeeting);
            }
            else{
                flattened.add(currentMeeting);
            }

        }


        return flattened;
    }

    private static List<Meeting> mergeCalendars(List<Meeting> updatedCaleandr1, List<Meeting> updatedCaleandr2) {
        List<Meeting> merged = new ArrayList<>();

        int i =0;
        int j =0;

        while(i < updatedCaleandr1.size() && j < updatedCaleandr2.size()){
            Meeting meeting1 = updatedCaleandr1.get(i);
            Meeting meeting2 = updatedCaleandr2.get(j);
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

    private static List<Meeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {

        List<StringMeeting> updatedCalendar = new ArrayList<>();
        updatedCalendar.add(new StringMeeting("00:00", dailyBounds.start));

        updatedCalendar.addAll(calendar);
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));

        List<Meeting> calenderInMinutes = new ArrayList<>();

        for (int i = 0; i < updatedCalendar.size(); i++) {
            calenderInMinutes.add(new Meeting(timeToMinutes(updatedCalendar.get(i).start), timeToMinutes
                    (updatedCalendar.get(i).end)));

        }

        return calenderInMinutes;
    }

    private static int timeToMinutes(String time) {

        int delimiterPos = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiterPos));
        int minutes = Integer.parseInt(time.substring(delimiterPos+1, time.length()));

        return hours* 60 + minutes;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "StringMeeting{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }
    static class Meeting{
        public int start;
        public int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end= end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
