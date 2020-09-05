package Google;

public class PeriodicString {
    public static void main(String[] args) {
        System.out.println(isPeriodic("abcabcabcabc", 3));
        System.out.println(isPeriodic("abcabcabcabc", 2));

        System.out.println(getSmallestPeriod("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s){
        int n = s.length();
        if(n < 2)
            return false;
        if (n==2) {
            return s.charAt(0) == s.charAt(1);
        }
        return true;

    }
    private static int getSmallestPeriod(String str) {
        for (int right = 1; right < str.length()/2; right++) {
            if(isPeriodic(str, right-0)){
                return right-0;
            }
        }
        return -1;
    }

    public static boolean isPeriodic(String str, int period ){
        for (int i = 0; i < str.length()-period; i++) {
            if(str.charAt(i) != str.charAt(i+period)){
                return false;
            }
        }
        return true;
    }
}
