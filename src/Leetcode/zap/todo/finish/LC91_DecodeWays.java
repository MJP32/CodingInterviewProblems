package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC91_DecodeWays {
    public static void main(String[] args) {
        LC91_DecodeWays lc91 = new LC91_DecodeWays();
        System.out.println("-> " +lc91.numDecodings("1262"));
        System.out.println("-> " +lc91.numDecodingsDP("1262"));

    }

    public int numDecodingsDP(String s) {
        int[] dp = new int[s.length() +1];

        dp[0] = 1;
        dp[1] = s.charAt(0) =='0' ? 0:1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1,i));

            int twoDigit = Integer.valueOf(s.substring(i-2,i));


            if(oneDigit >= 1 ){
                dp[i] +=dp[i-1];
            }

            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] +=dp[i-2];
            }

        }

        System.out.println(Arrays.toString(dp));


        return dp[s.length()];

    }
    public int numDecodings(String s) {
        int count =0;


        count = helper(s, count, 0);


        return count;
    }



    public static int helper(String S, int count,  int start ){


        if(start == S.length()){
            return 1;
        }

        if(start == S.length()-1){
            if(S.charAt(start)!=0){
                return 1;
            }
            return 0;
        }


        if(S.charAt(start) >0 -'0' && S.charAt(start) - '0' <=9){
//            System.out.println(S.charAt(start));
            count = helper(S.substring(start), count, start+1);
        }

        if(Integer.parseInt(S.substring(start, start+2)) >=10 && Integer.parseInt(S.substring(start, start+2)) <=26){
//            System.out.println(Integer.parseInt(S.substring(start, start+2)));
            count += helper(S.substring(start, start+2), count, start+1);
        }

        return count;

    }
}
