package bytebybyte.module4;

public class CountCombinations {
    public static void main(String[] args) {
        System.out.println(countCombinations(new int[]{1,2,3}));
    }

    private static int countCombinations(int[] arr) {

        return countCombinations(arr,0);
    }

    private static int countCombinations(int[] arr, int i) {
        if (i == arr.length) {
            return 1;
        }
        int include = countCombinations(arr, i+1);
        int exclude = countCombinations(arr, i+1);

        return include + exclude;
    }


}
