package Leetcode.topic.topologicalsort;

import java.util.*;

public class LC207_CourseSchedule {
    public static void main(String[] args) {

        /*
        1 0
        2 3
        3 2
        4 0

        1 [2, 3]
        2 []
        3 [2]
        4 [2, 3]

        int[][] courses = new int[][]{{1,0},{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};



        0 0
        1 1
        2 1

        0 [1]
        1 [2]
        2 []


        queue [0, 1, 2]

        int[][] courses = new int[][]{{1,0},{2,1}};
         */


//

        int[][] courses = new int[][]{{1,0},{2,1}};

        System.out.println(new LC207_CourseSchedule().canFinish(3, courses));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer,List<Integer>> graph = new HashMap<>();


        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1], child = prerequisites[i][0];
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
            graph.get(parent).add(child); // put the child into it's parent's list
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() ==0){
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            int num = queue.poll();
            sortedOrder.add(num);

            List<Integer> children = graph.get(num);
            for(int child : children){
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) ==0){
                    queue.add(child);
                }
            }


        }

        //sortedOrder.forEach(k-> System.out.println(k));

        return sortedOrder.size() == numCourses;
    }

}
