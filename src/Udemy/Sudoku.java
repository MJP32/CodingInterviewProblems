package Udemy;

public class Sudoku {
    private int[][] sodukuTable;

    public Sudoku(int[][] sodukuTable) {
        this.sodukuTable = sodukuTable;
    }
    public void solveProblem(){
        if(solve(0, 0)){
            showResults();
        }
        else{
            System.out.println("No solution");
        }
    }

    private boolean solve(int rowIndex, int colIndex) {
        if(rowIndex == Constants.BOARD_SIZE && ++colIndex == Constants.BOARD_SIZE){
            return true;
        }
        if (rowIndex == Constants.BOARD_SIZE) {
            rowIndex++;
        }
        if (sodukuTable[rowIndex][colIndex] !=0) {
            return solve(rowIndex+1,colIndex+1);
        }
        //TODO
        for (int number = Constants.MIN_NUMBER; number <2; number++) {

            if (valid(rowIndex,colIndex,number)) {
                sodukuTable[rowIndex][colIndex] = number;
                if (solve(rowIndex+1,colIndex)) {
                    return true;
                }
                //BACKTRACK
                sodukuTable[rowIndex][colIndex] =0;
                
            }
        }
        return false;

    }

    private boolean valid(int rowIndex, int colIndex, int number) {





        return true;
    }

    private void showResults() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if(i%3 ==0){
                System.out.println(" ");
            }
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (j%3 ==0) {
                    System.out.println(" ");
                }
                System.out.println(sodukuTable[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


}
class Constants{
    public static final int BOARD_SIZE = 9;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int BOX_SIZE = 3;
}