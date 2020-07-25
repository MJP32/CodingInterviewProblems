package Leetcode.topic.topologicalsort;

import java.util.*;

public class LC207_CourseSchedule {
    public static void main(String[] args) {

        /*
        1 0
        2 3
        3 2
        4 0
        */


          /*
        1 [2, 3]
        2 []
        3 [2]
        4 [2, 3]
         */


        int[][] courses = new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};

        System.out.println(new LC207_CourseSchedule().canFinish(4, courses));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree  =new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] req = prerequisites[i];
            if (!map.containsKey(req[1])) {
                map.put(req[1], new ArrayList<>());
            }
            map.get(req[1]).add(req[0]);
            //-1 because courses start at 1 not 0
            inDegree[req[0]-1]++;

        }

        //add courses with 0 prereqs to queue
        int count =0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] ==0) {
                queue.add(i);
            }
        }


        return true;
    }

}
