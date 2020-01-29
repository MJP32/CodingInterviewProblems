package KeepOnCoding;

import java.util.Arrays;

public class WallsAndGates {
    public static void main(String[] args) {

int[][] rooms = new int[][]{{0,0,0,-1},{0,0,0,0}};


new WallsAndGates().wallsAndGates(rooms);


        System.out.println(Arrays.deepToString(rooms));

    }
    public void wallsAndGates(int[][] rooms) {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == -1) {
                    dfs(rooms, i, j, 0);
                }
            }
        }


    }

    private void dfs(int[][] rooms, int i, int j, int depth) {

        if (isSafe(rooms,i,j)) {
            return;
        }

        if (rooms[i][j] ==0||rooms[i][j]> depth) {
            rooms[i][j]= depth;
        }


        dfs(rooms, i+1, j, depth+1);
        dfs(rooms, i-1, j, depth+1);
        dfs(rooms, i, j+1, depth+1);
        dfs(rooms, i, j-1, depth+1);

    }

    public boolean isSafe(int[][] rooms, int i, int j){
        if(i<0 || i >=rooms.length || j<0||j <=rooms[i].length|| rooms[i][j] ==-1){
            return false;
        }

        return true;
    }
}
