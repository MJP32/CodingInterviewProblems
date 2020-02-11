package Grokking.TwoPointers.challenge;

public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }


    public static boolean compare(String str1, String str2) {


        int str1Left =0;
        int str2Left =0;


        while (str1Left < str1.length() && str2Left < str2.length()) {
            if (str1.charAt(str1Left) == str2.charAt(str2Left)) {


                str1Left++;
                str2Left++;
            }
            else if (str1.charAt(str1Left) != str2.charAt(str2Left) || str2.charAt(str2Left+1) == '#') {


                str1Left++;
                str2Left++;
            }



        }





        return false;

    }
}
