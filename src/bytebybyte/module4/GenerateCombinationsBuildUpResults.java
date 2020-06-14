package bytebybyte.module4;


import java.util.LinkedList;
import java.util.List;

public class GenerateCombinationsBuildUpResults {
    public static void main(String[] args) {

        System.out.println(generateCombinations(new int[]{1,2,3}));
    }

    private static List<List<Integer>> generateCombinations(int[] arr) {

        return generateCombinations(arr,0);
    }

    private static List<List<Integer>> generateCombinations(int[] arr, int i) {
        if (i == arr.length) {
            List<List<Integer>> emptySet = new LinkedList<>();
            emptySet.add(new LinkedList<Integer>());
            return emptySet;
        }
        List<List<Integer>> toReturn = new LinkedList<>();
        for (List<Integer> result : generateCombinations(arr, i+1)) {
            toReturn.add(new LinkedList<Integer>(result));
            result.add(0,arr[i]);
            toReturn.add(new LinkedList<Integer>(result));
        }

        return toReturn;
    }


}
