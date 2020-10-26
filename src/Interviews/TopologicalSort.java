package Interviews;

import AlgoExpert.famous.Topo;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {

        /*

        Given a list of jobs and a list of arrays with [job, dependency]
        Find a possibble order of for the jobs

        jobs = {1,2,3,4}
        dependencies = {[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]}

        Possible Orders - [1, 4, 3, 2] or [4, 1, 3,2]

        1 0
        2 3
        3 2
        4 0


        1 [2, 3]
        2 []
        3 [2]
        4 [2, 3]


        1       4
         \    /
            3
            |
            2

         */

        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        deps.add(new Integer[]{4, 3});

        //int[][] courses = new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};

        new Topo().topologicalSort(4, deps).forEach(k -> System.out.println(k));

    }


    public static List<Integer> topologicalSort(int numJobs, List<Integer[]> deps) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] dependencyCount = new int[numJobs + 1];
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        for (Integer[] dep : deps) {
            if (!prereqMap.containsKey(dep[0])) {
                prereqMap.put(dep[0], new ArrayList<>());
            }
            prereqMap.get(dep[0]).add(dep[1]);
            dependencyCount[dep[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //start at one, because course numbers start at 1
        for (int i = 1; i < numJobs + 1; i++) {
            if (dependencyCount[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return result;
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            result.add(course);
            if (prereqMap.get(course) == null) {
                continue;
            }
            for (Integer nextCourse : prereqMap.get(course)) {
                dependencyCount[nextCourse]--;
                if (dependencyCount[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return result.size() == numJobs ? result : new ArrayList<>();
    }
}
