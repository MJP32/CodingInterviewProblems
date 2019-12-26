package Leetcode.zap.todo.submit;

public class LC459_RepeatedSubstring {
    public static void main(String[] args) {

        LC459_RepeatedSubstring lc459 = new LC459_RepeatedSubstring();

        System.out.println(lc459.repeatedSubstringPattern("abab"));

    }

    public boolean repeatedSubstringPattern(String s){
        int len =s.length();
        for (int i = len/2; i>=1; i++) {
            if(len % i ==0){
                int numRepeats = len/i;
                String substring = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < numRepeats; j++) {
                    sb.append(substring);
                }
                if(sb.toString().equals(s))
                    return true;
            }
        }


        return false;
    }
}
