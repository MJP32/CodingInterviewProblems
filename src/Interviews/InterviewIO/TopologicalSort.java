package Interviews.InterviewIO;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        /*
            Given a list of jobs and dependencies

            jobs[1,2,3,4]
            deps[[1,2],[1,3],[3,2],[4,2], [4,3]]

            ans = [1,4,3,2] or [4,1,3,2]

            1 0
            2 3
            3 2
            4 0

            1 [2, 3]
            2 []
            3 [2]
            4 [2, 3]

            1
         */
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        List<Integer> result = new ArrayList<Integer>();

        int[] jobCount = new int[jobs.size() + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Integer[] dep : deps) {

            if (!map.containsKey(dep[0])) {
                map.put(dep[0], new ArrayList<>());
            }
            map.get(dep[0]).add(dep[1]);

            jobCount[dep[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < jobCount.length; i++) {
            if (jobCount[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return result;
        }

        while (!queue.isEmpty()) {
            Integer job = queue.poll();

            result.add(job);

            if (map.get(job) == null)
                continue;
            for (Integer nextJob : map.get(job)) {
                jobCount[nextJob]--;
                if (jobCount[nextJob] == 0) {
                    queue.add(nextJob);
                }
            }

        }


        return result.size() == jobs.size() ? result : new ArrayList<Integer>();
    }
}
