package Leetcode.topic.graph;

import java.util.*;

public class LC797_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        new LC797_AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}).forEach(k-> System
                        .out.println(k));
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(0));
        int goalNode = graph.length -1;

        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int currNode = path.get(path.size()-1);
            if(currNode == goalNode){
                result.add(new ArrayList<>(path));
            }
            else {
                int[] neighbors = graph[currNode];
                for(int neighbor : neighbors){
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbor);
                    queue.add(list);
                }

            }

        }
        return result;
    }
}
