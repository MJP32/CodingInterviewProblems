package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;

public class LC286_WallsAndGates {
    public static int[][] rooms;
    public static void main(String[] args) {

        rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,-1,0,2147483647},{2147483647,-1,0,2147483647},{2147483647,-1,0,2147483647}};
        new LC286_WallsAndGates().wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));


    }
    public void wallsAndGates(int[][] rooms) {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0 ) {
                    dfs(i,j, 0, rooms );
                }
            }
        }
    }

    private void dfs(int i, int j, int count, int[][] rooms) {

        if (i<0 || i>=rooms.length || j<0|| j>=rooms[i].length || rooms[i][j] < count ) {
            return;
        }
        rooms[i][j] = count;

        dfs(i+1,j,count+1, rooms);
        dfs(i-1,j,count+1, rooms);
        dfs(i,j+1,count+1, rooms);
        dfs(i,j-1,count+1, rooms);

    }
}
