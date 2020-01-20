package Leetcode.zap.todo.finish;

import java.util.LinkedList;
import java.util.Queue;

public class LC207_CourseSchedule {
    public static void main(String[] args) {
        LC207_CourseSchedule lc207 = new LC207_CourseSchedule();
        System.out.println(lc207.canFinish(2, new int[][]{{1,0}}));
        System.out.println(lc207.canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
