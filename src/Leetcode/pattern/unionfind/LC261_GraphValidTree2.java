package Leetcode.pattern.unionfind;

import java.util.*;

public class LC261_GraphValidTree2 {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();

    public static void main(String[] args) {
//        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//        System.out.println(new LC261_GraphValidTree2().validTree(5, edges));
//
//        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
//        System.out.println(new LC261_GraphValidTree2().validTree(5, edges2));

        int[][] edges3 = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        System.out.println(new LC261_GraphValidTree2().validTree(5, edges3));
    }

    public boolean validTree(int n, int[][] edges) {
        int [] ids = new int[n];
        for(int i=0; i < ids.length;i++)
            ids[i] =i;
        for(int[] edge :edges){
            if(!union(edge[0],edge[1], ids)){
                return false;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i =0; i < ids.length; i++)
            set.add(find(i,ids));
        return set.size() ==1;

    }

    private boolean union(int edge1, int edge2, int[]ids){
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        if(parent1 == parent2){
            return false;
        }
        ids[parent1] = parent2;
        return true;
    }

    //returns parent of the edge
    private int find(int edge, int[] ids){
        if(ids[edge] != edge){
            //path comprerssion
            ids[edge] = find(ids[edge], ids);
        }
        return ids[edge];
    }



}
