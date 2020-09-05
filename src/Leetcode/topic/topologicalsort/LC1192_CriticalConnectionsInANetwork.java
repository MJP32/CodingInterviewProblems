package Leetcode.topic.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1192_CriticalConnectionsInANetwork {
    ArrayList<Integer>[] graph;
    List<List<Integer>> criticalConnections;
    int[] visitedTimes;
    int[] lowTimes;
    int time;

    public static void main(String[] args) {


        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> connection = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));


        connections.forEach(k-> System.out.println(k));
        new LC1192_CriticalConnectionsInANetwork().criticalConnections(4, connections);

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /*
        0: 1
        1: 2,3
        2: 0
        3:



        0: 1
        1: 2
        2: 1
        3: 0  -> citical
          */

       graph = new ArrayList[n];
       criticalConnections = new ArrayList<>();
       visitedTimes = new int[n];
       lowTimes = new int[n];
       time =0;

       buildGraph(connections);
       boolean[] visited = new boolean[n];
       dfs(visited, 0, -1);
        return criticalConnections;
    }

    private void dfs(boolean[] visited, int current, int parent) {
        visited[current] = true;
        visitedTimes[current] = time;
        lowTimes[current] = time;
        time++;

        for (int neighbor: graph[current]) {
            if (neighbor == parent) {
                continue;
            }
            if (!visited[neighbor]) {
                dfs(visited, neighbor, current);
                lowTimes[current] = Math.min(lowTimes[current], lowTimes[neighbor]);
                if (visitedTimes[current] < lowTimes[neighbor]) {
                    criticalConnections.add(Arrays.asList(current,neighbor));
                }
            }
            else{
                lowTimes[current] = Math.min(lowTimes[current], visitedTimes[neighbor]);
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn: connections) {
            int a = conn.get(0);
            int b = conn.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

    }
}
