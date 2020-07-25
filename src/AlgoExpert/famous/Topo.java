package AlgoExpert.famous;

import java.util.*;

public class Topo {
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


          /*
          "deps": [
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [1, 6],
    [1, 7],
    [2, 8],
    [3, 8],
    [4, 8],
    [5, 8],
    [6, 8],
    [7, 8],
    [2, 3],
    [2, 4],
    [5, 4],
    [7, 6],
    [6, 2],
    [6, 3],
    [6, 5],
    [5, 9],
    [9, 8],
    [8, 0],
    [4, 0],
    [5, 0],
    [9, 0],
    [2, 0],
    [3, 9],
    [3, 10],
    [10, 11],
    [11, 12],
    [2, 12]
  ],
  "jobs": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

           */


        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        deps.add(new Integer[]{4, 3});

        int[][] courses = new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};

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


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] req = prerequisites[i];
            if (!map.containsKey(req[1])) {
                map.put(req[1], new ArrayList<>());
            }
            map.get(req[1]).add(req[0]);
            //-1 because courses start at 1 not 0
            inDegree[req[0] - 1]++;

        }

        //add courses with 0 prereqs to queue
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        return true;
    }

}
