package Leetcode.topic.stg;

import java.util.Stack;

public class LC402_RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(new LC402_RemoveKDigits().removeKdigits("1432219", 3));
    }
    public String removeKdigits(String num, int k) {

        if(num.length() <= k){
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for(Character c : num.toCharArray()){
            stack.add(c);
        }




        int counter =0;
        while(counter < num.length()){
            while(k> 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter) ){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
        }

        //for case "111"
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }



        sb.reverse();
        //delete starting 000
        int i =0;
        while(sb.length() >1 && sb.charAt(i)=='0'){
            sb.deleteCharAt(i);
            i++;
        }


        return sb.toString();
    }
}
