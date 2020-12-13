package DailyByte;

import java.util.Stack;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reveseVowels("computer"));
    }

    private static String reveseVowels(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(letter == 'a' || letter == 'e'||letter == 'i'||letter == 'o'||letter == 'u'){
                stack.push(letter);
            }

        }
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(letter == 'a' || letter == 'e'||letter == 'i'||letter == 'o'||letter == 'u'){
                reversed.append(stack.pop());
            }
            else{
                reversed.append(letter);
            }

        }
        return reversed.toString();


    }
}
