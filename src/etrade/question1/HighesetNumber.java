package etrade.question1;

import java.util.Arrays;

public class HighesetNumber {
    public static void main(String[] args) {
//        int[] numbers = new int[]{5,4,14,7,2,18,11};
        int[] numbers = new int[]{};
        try {
            System.out.println(highestNumber(numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int highestNumber(int[] numbers) throws Exception {
        if(numbers == null || numbers.length ==0)
            throw new Exception("Empty array ");

        return Arrays.stream(numbers).max().getAsInt();
    }
}
