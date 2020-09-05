package Leetcode.pattern.bfs;

import java.util.*;

public class LC261_GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(new LC261_GraphValidTree().validTree(5, edges));

        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(new LC261_GraphValidTree().validTree(5, edges2));
    }



    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        seen.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjacencyList.get(node)){
                if (seen.contains(neighbor)) {
                    continue;
                }
                seen.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return seen.size() == n;
    }


}
