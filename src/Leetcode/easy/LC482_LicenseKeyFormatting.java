package Leetcode.easy;

public class LC482_LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(new LC482_LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new LC482_LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
    }
    public String licenseKeyFormatting(String S, int K) {
        S= S.replaceAll("-","");

        StringBuilder sb = new StringBuilder();
        int i = S.length() -1;
        while(i >=0){
            int num = K;
            while(num > 0 && i >=0){
                //S= S.toUpperCase(S.charAt(i));
                sb.insert(0,Character.toUpperCase(S.charAt(i)));
                num--;
                i--;
            }
            if(i != -1)
                sb.insert(0,'-');


        }
        return sb.toString();
    }
}
