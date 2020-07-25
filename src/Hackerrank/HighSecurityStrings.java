package Hackerrank;

public class HighSecurityStrings {
    public static void main(String[] args) {
        System.out.println(getStrength("hellomrz", 2));
    }
    public static int getStrength(String password, int weight_a) {
        int result = 0;
        for(int i =0; i< password.length();i++ ){
            result+= (password.charAt(i) - 'a' +weight_a)%26;
        }
        return result;
    }
}
