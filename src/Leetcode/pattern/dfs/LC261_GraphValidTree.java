package Leetcode.pattern.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC261_GraphValidTree {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(new LC261_GraphValidTree().validTree(5, edges));

        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(new LC261_GraphValidTree().validTree(5, edges2));
    }

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs(0, -1) && seen.size() == n;
    }
    public boolean dfs(int node, int parent){
        if (seen.contains(node)) {
            return false;
        }
        seen.add(node);
        for (int neighbor : adjacencyList.get(node)) {
            if (parent != neighbor) {
                boolean result = dfs(neighbor, node);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

}
