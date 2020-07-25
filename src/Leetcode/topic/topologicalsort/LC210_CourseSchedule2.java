package Leetcode.topic.topologicalsort;

import java.util.*;

public class LC210_CourseSchedule2 {
    public static void main(String[] args) {

        /*

            0: 1, 2
            1: 3
            2: 3
            3:

            0: 0
            1: 1   ->0
            2: 1   ->0
            3: 2

        */




        int[][] courses = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(Arrays.toString(new LC210_CourseSchedule2().findOrder(4, courses)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] dependencyCount = new int[numCourses];
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        for(int[] req: prerequisites){

            if(!prereqMap.containsKey(req[1])){
                    prereqMap.put(req[1], new ArrayList<>());
            }

            prereqMap.get(req[1]).add(req[0]);
            dependencyCount[req[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(dependencyCount[i] ==0){
                queue.add(i);
            }
        }

        if(queue.isEmpty()){
            return new int[0];
        }

        int[] res = new int[numCourses];
        int idx =0;

        while(!queue.isEmpty()){

            Integer course = queue.poll();
            res[idx++] = course;
            if(prereqMap.get(course) == null){
                continue;
            }
            for(Integer nextCourse : prereqMap.get(course)){
                dependencyCount[nextCourse]--;
                if(dependencyCount[nextCourse] ==0){
                    queue.add(nextCourse);
                }
            }


        }


        if(idx != numCourses){
            return new int[]{};
        }
        else{
            return res;
        }
    }

}
