package Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grades {
    public static void main(String[] args) {

        String[][] grades = new String[][]{{"Charles","87"},{"Bobby", "50"},{"Charles","22"},{"Mike", "2"}};

        System.out.println(getHighest(grades));
    }

    private static int getHighest(String[][] grades) {
        Map<String, List<String>> students = new HashMap<>();

        for (int i = 0; i < grades.length; i++) {
            String name = grades[i][0];
            String score = grades[i][1];/*
            if(!students.containsKey(name)){
                students.put(name, new ArrayList<>());
            }
            */
            students.putIfAbsent(name,new ArrayList<>());
            students.get(name).add(score);
        }
        System.out.println(students);
        int highest =0;
        for(Map.Entry<String, List<String>> entry : students.entrySet()){
            List<String> list = entry.getValue();
            int total = 0;
            for (String s : list) {
                total += Integer.valueOf(s);
            }
            highest = Math.max(highest, total/list.size());
        }
        return highest;
    }

}
