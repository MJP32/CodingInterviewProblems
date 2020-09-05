package Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedSubstring {
    public static void main(String[] args) {
//substringK("democracy", 5).forEach(k-> System.out.println(k));
//substringK("wawaglknagagwunagkwkwagl", 4).forEach(k-> System.out.println(k));
substringK("aaabb", 2).forEach(k-> System.out.println(k));
    }

    public static List<String> substringK(String str, int num){
        List<String> result = new ArrayList<>();
        if (str == null || str.length()==0) {
            return result;
        }
        for (int i = 0; i < str.length()-num + 1; i++) {
            String string = str.substring(i, i+num);
            if(isValid(string)){
                result.add(string);
            }

        }
        return result;
    }

    public static boolean isValid(String str){
        boolean once = false;
        boolean twice = false;
        Set<Character> set = new HashSet<>();

        for(char c : str.toCharArray()){
            if(set.contains(c)){
                if(!once) {
                    once = true;
                    continue;
                }
                else
                    return false;
            }
            if(once){
                if(set.contains(c)){
                    return false;
                }
            }
            set.add(c);

        }


        return once;
    }
}
