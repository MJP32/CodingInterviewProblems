package AlgoExpert.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersInPi {
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
        int minSpaces= getMinSpaces(pi, numbersTable, 0);
        return minSpaces == Integer.MAX_VALUE ? -1:minSpaces;
    }

    private static int getMinSpaces(String pi, Set<String> numbersTable, int idx) {

        if(idx == pi.length()){
            return -1;
        }
        int minSpaces = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length() ; i++) {
            String prefix = pi.substring(idx, i+1);
            if (numbersTable.contains(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, i+1);
                if (minSpacesInSuffix == Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix);
                }
                else {
                    minSpaces = Math.min(minSpaces,minSpacesInSuffix+1);
                }
            }
        }



        return minSpaces;
    }
}
