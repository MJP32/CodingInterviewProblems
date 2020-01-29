package Leetcode.easy;

public class LC557_ReverseString {
    public static void main(String[] args) {

        System.out.println(new LC557_ReverseString().reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {

       // String reversedString = reverse(s);


        String[] strArr = s.split(" ");


        String result = "";
        for (String word: strArr){
            //System.out.println(word);

            result +=reverse(word)+" ";
        }


        return result.trim();

    }

    public String reverse(String str ){


        char[] tempArray= str.toCharArray();


        int begin =0;
        int end = tempArray.length-1;

        while(begin<end){


            char temp = tempArray[begin];

            tempArray[begin] = tempArray[end];
            tempArray[end] = temp;


            begin++;
            end--;


        }


        return String.valueOf(tempArray);

        //return new StringBuilder(str).reverse().toString();

    }
}
