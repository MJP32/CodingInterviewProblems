package Leetcode.easy;

public class LC67_AddBinary {
    public static void main(String[] args) {
        LC67_AddBinary lc67 = new LC67_AddBinary();
        String a = "1010", b = "1011";
        System.out.println(lc67.addBinary(a, b));
    }

    public String addBinary(String a, String b) {

            StringBuilder sb = new StringBuilder();
            int i = a.length()-1;
            int j = b.length()-1;
            int carry =0;
            int sum =0;
            while(i >=0 || j>=0 ){
                sum = carry;
                if(i>=0)
                  sum +=  a.charAt(i--)-'0';

                if(j>=0)
                    sum +=  a.charAt(j--)-'0';
                carry =0;
                if ( sum == 2) {
                    sum = 0;
                    carry = 1;
                } else if(sum == 3){
                    sum = 1;
                    carry = 1;
                }
                sb.insert(0,sum);
            }
            if(carry > 0)
                return sb.insert(0,1).toString();
            else
                return sb.toString();
    }
}
