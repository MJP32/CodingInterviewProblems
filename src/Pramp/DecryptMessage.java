package Pramp;

public class DecryptMessage {
    static String decrypt(String word) {
        // your code goes here
        int val =0;
        String result ="";
        int step2 =0;
        for(int i =0; i<word.length(); i++){

            char c = word.charAt(i);
            if(i==0){
                val=c-1;
                step2 = c;
            }
            else{

                val = c +26  - step2;
                step2 += val;
                while(val < (int)'a' ){
                    val += 26 ;
                }



            }
            //System.out.print("val " +val);
            //System.out.println(" step2 "+step2);
            result += (char)val;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));
    }
}
