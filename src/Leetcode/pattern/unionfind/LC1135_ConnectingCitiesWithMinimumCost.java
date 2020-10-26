package Leetcode.pattern.unionfind;

import java.util.Arrays;

public class LC1135_ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
//        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
//        int N = 3;
        int[][] connections = {{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}};
        int N = 5;
        System.out.println("set is " + new LC1135_ConnectingCitiesWithMinimumCost().minimumCost(N, connections));
    }

    int minimumCost = 0;
    public int minimumCost(int N, int[][] connections) {
        int[] ids = new int[N + 1];
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for(int i = 0; i < N; i++){
            ids[i] = i;
        }
        for(int[] connection : connections){
            union(connection[0], connection[1], ids, connection);
        }
        int parentCount = 0;
        for(int i = 0; i < N; i++) {
            if (ids[i] == i)
                parentCount++;
        }
        if (parentCount != 1)
            return -1;
        return minimumCost;
    }

    public int find(int x, int[] ids) {
        if (ids[x] == x) {
            return x;
        }
        return find(ids[x], ids);
    }


    public void union(int x, int y, int[] ids, int[] connection) {
        x = find(x, ids);
        y = find(y, ids);
        if (x != y) {
            minimumCost += connection[2];
            ids[y] = x;
        }
    }
}
