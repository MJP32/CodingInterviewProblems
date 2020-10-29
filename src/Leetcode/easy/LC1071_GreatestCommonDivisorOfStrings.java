package Leetcode.easy;

public class LC1071_GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(new LC1071_GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new LC1071_GreatestCommonDivisorOfStrings().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));

    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2+str1)){
            return "";
        }
        if(str1.equals(str2)){
            return str1;
        }
        //if(str2.length() == 0) return str1;

        if(str1.length() < str2.length()){
            return gcdOfStrings(str2, str1);
        }

        str1 = str1.substring(str2.length());

        return gcdOfStrings(str1, str2);




    }
    public String gcdOfStrings2(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        if(str1 == str2) return str1;
        if(str1.length() > str2.length()){
            return gcd(str1, str2);
        } else {
            return gcd(str2, str1);
        }
    }

    private String gcd(String str1, String str2){
        if(str2.length() == 0) return str1;
        str1 = str1.substring(str2.length());
        if(str1.length() > str2.length()){
            return gcd(str1, str2);
        } else {
            return gcd(str2, str1);
        }
    }
}
