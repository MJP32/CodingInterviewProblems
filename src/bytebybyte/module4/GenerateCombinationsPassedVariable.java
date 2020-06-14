package bytebybyte.module4;


import java.util.LinkedList;
import java.util.List;

public class GenerateCombinationsPassedVariable {
    public static void main(String[] args) {

        System.out.println(generateCombinations(new int[]{1,2,3}));
    }

    private static List<List<Integer>> generateCombinations(int[] arr) {
        List<List<Integer>> results= new LinkedList<>();
        generateCombinations(arr,0, results, new LinkedList<>());
        return results;
    }

    private static void generateCombinations(int[] arr, int i, List<List<Integer>> results, List<Integer> path) {

        if (i == arr.length) {
            results.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new LinkedList<>(path);
        pathWithCurrent.add(arr[i]);

        generateCombinations(arr, i+1, results, path);
        generateCombinations(arr, i+1, results, pathWithCurrent);

    }




}
