package AlgoExpert.easy;

public class CaeserCypherEncryptor {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz",2));
    }
    public static String caesarCypherEncryptor(String str, int key) {
        String result = "";
        for(int i =0; i< str.length();i++){

            result  += (char)((str.charAt(i) -'a' +key)%26);


        }
        return result;
    }
}
