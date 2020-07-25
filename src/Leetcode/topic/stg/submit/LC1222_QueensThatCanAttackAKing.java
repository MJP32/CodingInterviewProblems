package Leetcode.topic.stg.submit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1222_QueensThatCanAttackAKing {
    public static void main(String[] args) {

        int[][] queens= new int [][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int [] king = new int[]{0,0};

        new LC1222_QueensThatCanAttackAKing().queensAttacktheKing(queens, king).forEach(k-> System.out.println(k));
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];

        for(int[] queen : queens){
            seen[queen[0]] [queen[1]] = true;
        }

        int[] directions ={-1,0,1};
        for (int dx : directions){
            for (int dy : directions ){
                if(dx ==0 && dy ==0){
                    continue;
                }
                int x = king[0];
                int y = king[1];

                while(x + dx >=0 && x + dx < 8 && y +dy >=0 && y +dy < 8 ){

                    x += dy;
                    y +=dy;

                    if(seen[x][y]){
                        result.add(Arrays.asList(x,y));
                        break;
                    }
                }
            }
        }


        return result;
    }


//    private boolean isPlaceValid(int rowIndex, int colIndex) {
//
//        for (int i = 0; i < colIndex; i++) {
//            if (chessTable[rowIndex][i]==1) {
//                return false;
//            }
//        }
//        for (int i = rowIndex, j=colIndex; i>=0&& j >=0 ; i--,j--) {
//            if (chessTable[i][j]==1) {
//                return false;
//            }
//
//        }
//
//        //diagonal
//        for (int i = rowIndex, j =colIndex; i<chessTable.length && j>=0 ; i++ ,j--) {
//            if (chessTable[i][j] == 1) {
//                return false;
//            }
//
//        }
//        return true;
//
//    }
}
