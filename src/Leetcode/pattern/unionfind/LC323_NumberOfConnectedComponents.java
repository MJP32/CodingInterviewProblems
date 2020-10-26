package Leetcode.pattern.unionfind;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC323_NumberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
        System.out.println(new LC323_NumberOfConnectedComponents().countComponents(5, edges));



        int[][] edges2 = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        System.out.println(new LC323_NumberOfConnectedComponents().countComponents(5, edges2));

        int[][] edges3 = new int[][]{{0,1},{1,2},{2,3},{0,5},{5,6},{3,8},{5,10},{10,11}};
        System.out.println(new LC323_NumberOfConnectedComponents().countComponents(20, edges3));

//        int[][] edges4 = new int[][]{{1,2,5},{1,3,6},{2,3,1}};
//        System.out.println(new LC323_NumberOfConnectedComponents().countComponents(3, edges4));

    }
    public int countComponents(int n, int[][] edges) {
        int [] ids = new int[n];
        for(int i=0; i < ids.length;i++)
            ids[i] =i;
        for(int[] edge :edges){
            union(edge[0],edge[1], ids);
        }

        System.out.println(Arrays.toString(ids));
        Set<Integer> set = new HashSet<>();
        for(int i =0; i < ids.length; i++)
            set.add(find(i,ids));
        return set.size();
    }
    private void union(int edge1, int edge2, int[]ids){
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
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
