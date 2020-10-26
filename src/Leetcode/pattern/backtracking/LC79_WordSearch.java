package Leetcode.pattern.backtracking;

public class LC79_WordSearch {
    public static void main(String[] args) {
        LC79_WordSearch lc79 = new LC79_WordSearch();

        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };

        System.out.println(lc79.exist(board, "ABCCED"));
        System.out.println(lc79.exist(board, "DOG"));
    }
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        for(int i =0; i< board.length;i++){
            for(int j =0; j< board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    result =  dfs(board, i, j, 0, word);
                    if(result)
                        return true;
                }
            }
        }

        return result;
    }

    private boolean dfs(char[][] board, int i, int j, int count, String word) {

        if(count == word.length()){
            return true;
        }
        if(i <0 || i >= board.length || j < 0 || j >= board[i].length ||board[i][j] != word.charAt(count)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';



        boolean found = dfs(board, i+1, j, count+1, word)
                ||dfs(board, i-1, j, count+1, word)
                ||dfs(board, i, j+1, count+1, word)
                ||dfs(board, i, j-1, count+1, word);

        board[i][j] = temp;
        return found;
    }

}
