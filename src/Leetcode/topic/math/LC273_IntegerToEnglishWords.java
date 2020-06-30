package Leetcode.topic.math;

public class LC273_IntegerToEnglishWords {
    private static final String[] LESS_THAN_TWENTY = {"","One","Two","Three","Four","Five","Six","Seven",
            "Eight","Nine","Ten","Eleven","Twelve","Thirteen",
            "Fourteen","Fifteen","Sixteen","Seventeen","Eighteen",
            "Nineteen"};

    private static final String[] TWENTY = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
            "Eighty","Ninety"};
    public String numberToWords(int num) {

        if(num==0)
            return "Zero";

        return helper(num);
    }


    public String helper(int num){
        //base case
        if(num==0)
            return "";

        StringBuilder sb = new StringBuilder();

        if(num >=1000000000){
            sb.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        }
        else if(num >=1000000){
            sb.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        }
        else if(num >=1000){
            sb.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        }
        else if(num >= 100){
            sb.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        }
        else if(num >=20){
            sb.append(TWENTY[num/10]).append(" ").append(helper(num%10));
        } else{
            sb.append(LESS_THAN_TWENTY[num]);
        }

        return sb.toString().trim();
    }
}
