package Interviews;

import java.util.Random;

public class ShuffleString {
    static Random rand = new Random();
    public static void main(String[] args) {
        System.out.println(shuffleString("Michael"));
    }

    private static String shuffleString(String str) {
        String shuffledString = "";
        char[] charArr = str.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            swap(charArr, i, randRange(i, charArr.length));
        }

        return String.valueOf(charArr);
    }

    public static int randRange(int min, int max){
        int ra = rand.nextInt(max-min) +min;
        System.out.println(ra);
        return ra ;
    }

    public static void swap(char[] charArray, int i, int j){
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
