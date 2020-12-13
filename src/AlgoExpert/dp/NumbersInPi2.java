package AlgoExpert.dp;

import java.util.*;

public class NumbersInPi2 {
    public static void main(String[] args) {
        String pi = "3141592653589793238462643383279";
        String[] numbers = {"314159265358979323846",
                "26433",
                "8",
                "3279",
                "314159265",
                "35897932384626433832",
                "79"};
        System.out.println(numbersInPi(pi, numbers));
    }
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbersTable = new HashSet<>(Arrays.asList(numbers));
        int minSpaces= getMinSpaces(pi, numbersTable, 0, new ArrayList<>());
        return minSpaces == Integer.MAX_VALUE ? -1:minSpaces;
    }

    private static int getMinSpaces(String pi, Set<String> numbersTable, int idx, List<String> results) {

        if (pi.length() ==0) {
            results.add("");
            return results.size();
        }
        for(String word: numbersTable){
            if(pi.startsWith(word)){

            }

        }



        return -1;
    }
}
