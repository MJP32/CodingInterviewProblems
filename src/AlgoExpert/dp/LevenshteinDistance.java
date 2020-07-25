package AlgoExpert.dp;

import java.util.Arrays;

public class LevenshteinDistance {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("ABCDEFG","ABDFFGH"));
//        System.out.println(levenshteinDistance("yabd","abc"));
//        System.out.println(levenshteinDistance("sea","eat"));
//        System.out.println(levenshteinDistance("a","b"));
    }
    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str2.length()+1][str1.length()+1];


        for (int i = 0; i < str1.length()+1; i++) {
            edits[0][i] = i;
        }
        for (int i = 0; i < str2.length()+1; i++) {
            edits[i][0] =i;
        }

        for (int i = 1; i < str2.length()+1; i++) {
            for (int j = 1; j < str1.length()+1; j++) {
                if (str2.charAt(i-1) == str1.charAt(j-1)) {
                    edits[i][j] = edits[i-1][j-1];
                }
                else{
                    edits[i][j] = 1+ Math.min(edits[i-1][j-1], Math.min(edits[i-1][j], edits[i][j-1]));
                }

            }

        }



        for(int[] arr : edits){

            System.out.println(Arrays.toString(arr));
        }

        return edits[str2.length()][str1.length()];
    }
}
