package AlgoExpert.famous;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        System.out.println(knuthMorrisPrattAlgorithm("aefaefaefaedaefaedaefaef","aefaedaefaefa"));
    }
    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        int[] pattern = buildPattern(string, substring);

        //System.out.println(Arrays.toString(pattern));
        return doesMatch(string, substring, pattern);
    }

    private static int[] buildPattern(String string, String substring) {
        int [] patterns = new int[substring.length()];

        Arrays.fill(patterns, -1);


        int j =0;
        int i =1;
        while (i < substring.length()) {

            if(substring.charAt(i) == substring.charAt(j)){
                patterns[i] = j;
                i++;
                j++;

            }
            else if(j>0){
                j = patterns[j-1]+1;
            }
            else{
                i++;
            }

        }

        return patterns;
    }

    private static boolean doesMatch(String string, String substring, int[] pattern) {


        int i =0;
        int j =0;

        while(i + substring.length()-j <= string.length()  ){
            if(string.charAt(i) == substring.charAt(j)){
                if( j ==substring.length() -1){
                    return true;
                }
                i++;
                j++;
            }
            else if(j > 0){
                j = pattern[j-1]+1;
            }
            else{
                i++;
            }
        }


        return false;
    }

}
