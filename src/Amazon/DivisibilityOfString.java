package Amazon;

public class DivisibilityOfString {
    public static void main(String[] args) {

        String s = "bcdbcdbcdbcd";
        String t = "bcdabc";

        System.out.println(findSmallestDivisor(s, t));

         s = "bcdbcdbcd";
         t = "bcdbcd";

        System.out.println(findSmallestDivisor(s, t));

        s = "bcdbcdbcdbcd";
        t = "bcdbcd";

        System.out.println(findSmallestDivisor(s, t));

        s = "bcdbcdbcdbcd";
        t = "bcd";
        System.out.println(findSmallestDivisor(s, t));
        s = "lrbb";
        t = "lrbb";


        System.out.println(findSmallestDivisor(s, t));
        //System.out.println(repeatedSubstringPatternKMP(s));
    }

    public static int findSmallestDivisor(String s, String t) {
        int len1 = repeatedSubstringPatternKMP(s);
        int len2 = repeatedSubstringPatternKMP(t);
        int repeatedLength;
        if (len1 != len2 || !s.substring(0,len1).equals(t.substring(0,len2))) {
            return -1;
        } else {
            repeatedLength = len1;
        }

        if ((s.length() / repeatedLength) % (t.length() / repeatedLength) != 0) {
            return -1;
        }
        else
            return repeatedLength;
    }



    public static boolean findSmallestDivisor2(String s, String t) {
        int begin = 0;
        int end = t.length();
        while (begin < s.length() && end < s.length()) {
            if (!s.substring(begin, end).equals(t)) {
                return false;
            }
            begin = end;
            end = end + t.length();

        }
        return end == s.length();

    }

    public static int repeatedSubstringPatternKMP(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int i = 1;
        int j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else
                    i++;
            }
        }
        if (lps[n - 1] == 0) {
            return s.length();
        }

        int repeatedSubstringLength = n - lps[n - 1];
        //return n % repeatedSubstringLength == 0;
        return repeatedSubstringLength;

    }
}
