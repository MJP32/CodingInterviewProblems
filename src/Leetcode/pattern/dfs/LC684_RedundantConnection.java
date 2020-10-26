package Leetcode.pattern.dfs;

import java.util.*;

public class LC684_RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(new LC684_RedundantConnection().findRedundantConnection(edges)));
        int[][] edges2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(new LC684_RedundantConnection().findRedundantConnection(edges2)));



    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();


        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dfs(u,v, graph, new HashSet<>())){
                return edge;
            }
            ArrayList<Integer> list1 = graph.getOrDefault(u, new ArrayList<>());
            list1.add(v);
            graph.put(u,list1);

            ArrayList<Integer> list2 = graph.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            graph.put(v,list2);
        }

        return new int[0];
    }


    private boolean dfs(int u, int v, Map<Integer, ArrayList<Integer>> graph,
                        HashSet<Integer> visited) {
        if (visited.contains(u)) {
            return false;
        }

        if(u ==v){
            return true;
        }
        visited.add(u);

        for(int i : graph.getOrDefault(v,new ArrayList<>())){
            if(dfs(i, v, graph, visited)){
                return true;
            }

        }
        return false;
    }

}
