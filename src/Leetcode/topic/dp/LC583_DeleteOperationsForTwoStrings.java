package Leetcode.topic.dp;

public class LC583_DeleteOperationsForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] edits = new int[word2.length()+1][word1.length()+1];


        for (int i = 0; i < word1.length()+1; i++) {
            edits[0][i] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            edits[i][0] =i;
        }

        for (int i = 1; i < word2.length()+1; i++) {
            for (int j = 1; j < word1.length()+1; j++) {
                if (word2.charAt(i-1) == word1.charAt(j-1)) {
                    edits[i][j] = edits[i-1][j-1];
                }
                else{
                    //no diagonal
                    edits[i][j] = 1+ Math.min(edits[i-1][j], edits[i][j-1]);
                }

            }

        }




        return edits[word2.length()][word1.length()];
    }
}
