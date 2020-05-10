package Grokking.CH3_FastSlowPointers;

public class Ch_3_3_HappyNumber {
    public static boolean find(int num) {
        int fast= num;
        int slow = num;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
            
        } while (slow != fast);





        return slow ==1;
    }

    private static int findSquareSum(int num) {

        int sum =0;
        while (num > 0) {
            int digit = num %10 ;

            sum  += digit  * digit;

            num /= 10;

        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(Ch_3_3_HappyNumber.find(23));
        System.out.println(Ch_3_3_HappyNumber.find(12));
    }
}
