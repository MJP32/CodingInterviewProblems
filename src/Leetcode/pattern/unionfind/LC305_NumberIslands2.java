package Leetcode.pattern.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC305_NumberIslands2 {


    private int rows, cols, numIslands;

    public static void main(String[] args) {

        int[][] grid = {{0,0}, {0,1},{1,2},{2,1}};

        LC305_NumberIslands2 lc305 = new LC305_NumberIslands2();
        System.out.println(lc305.numIslands2(3, 3, grid));
//        System.out.println(lc305.numIslands2(grid2));


    }

    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m*n);

        for(int[] pos : positions){

            int x = pos[0];
            int y = pos[1];

            int cellToCheck = x * n +y;
            if(uf.find(cellToCheck) != -1) {
                result.add(uf.connected); //Handle Duplicates Scenario
                continue;
            }
            uf.setParent(cellToCheck);
            for(int[] dir: directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                int cellToCheck2 = newX * n + newY;
                if(isSafe(newX, newY, m, n, uf))
                    uf.union(cellToCheck, cellToCheck2);
            }
            result.add(uf.connected);
        }
        return result;
    }

    private boolean isSafe(int x, int y, int m, int n, UnionFind uf) {
        if(x>= 0 && y >= 0 && x< m && y < n && uf.find(x*n+y) != -1){
            return true;
        }
        return false;
    }



    class UnionFind {
        int[] parent;
        int[] rank;
        int connected;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            connected = 0;
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }
        public void setParent(int i ){
            parent[i] =i;
            connected++;
        }

        private int find(int x) {
            if (parent[x] == -1) {
                return -1;
            }if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]); // Path compression
        }

        // Return false if x and y are in the same disjoint set already
        public void union(int x, int y) {
            System.out.println(x + " " + y);
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            if(rank[parentX]< rank[parentY])
                parent[parentX] = parentY;
            else if(rank[parentY]> rank[parentX]){
                parent[parentY] = parentX;
            }
            else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            connected--;
        }
    }

}
