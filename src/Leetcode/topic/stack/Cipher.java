package Leetcode.topic.stack;

public class Cipher {
    public static void main(String[] args) {
        System.out.println(new Cipher().rotationalCipher("Zebra-493", 3));
    }
    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuffer result= new StringBuffer();

        for (int i=0; i<input.length(); i++)
        {
            if (Character.isUpperCase(input.charAt(i)))
            {
                char ch = (char)(((int)input.charAt(i) + rotationFactor - 65) % 26 + 65);
                result.append(ch);
            }
            else if(Character.isLowerCase(input.charAt(i)))
            {
                char ch = (char)(((int)input.charAt(i) + rotationFactor - 97) % 26 + 97);
                result.append(ch);
            }
            else if(Character.isDigit(input.charAt(i))){
                result.append(((input.charAt(i)- '0')+ rotationFactor)%10);
            }
            else{
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
