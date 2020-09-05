package Leetcode.pattern.unionfind;

import java.util.*;

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
        int[] uf = new int[n];
        Arrays.fill(uf,-1);

        for (int[] edge: edges) {
            if (!union(edge[0], edge[1], uf)) {
                return false;
            }
        }
        int count =0;
        // check if these is more than one node that is pointing to itself.
        // Yes means it is not forming a valid tree or graph is not connected
        for(int i : uf)
            if(i==-1)
                if(count==1) return false;
                else count++;
        return true;

    }

    private boolean union(int n1, int n2, int[] uf) {
        // find the parents of the nodes
        int p1 = find(uf, n1);
        int p2 = find(uf, n2);

        // if parent are same, that means graph forms a cycle return false
        if (p1 == p2) return false;

        // make p1 as parent of p2,it means merging two sets into 1
        uf[p2] = p1;
        return true;


    }

    private int find(int[] uf, int node) {
        if (uf[node] == -1)
            return node;
        else
            return find(uf, uf[node]);
    }

}
