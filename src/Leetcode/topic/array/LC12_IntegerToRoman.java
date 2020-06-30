package Leetcode.topic.array;

public class LC12_IntegerToRoman {
    public static void main(String[] args) {
        LC12_IntegerToRoman lc12 = new LC12_IntegerToRoman();

        System.out.println(lc12.intToRoman(1345));
    }
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


        return
                M[num/1000]+C[num%1000/100]+ X[num%100/10]+I[num%10];

    }
}

