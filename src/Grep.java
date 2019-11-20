import java.util.ArrayList;
import java.util.List;

public class Grep {
    public static void main(String[] args) {

        String search ="abc";
        String text ="aaaabcbbbbbbbbbabccccccccabc";


        List<Integer> ans = grep(search,text);

        ans.forEach(System.out::println);

    }

    public static List<Integer> grep(String search, String text){
        List<Integer> results = new ArrayList<>();

        int p =0;

        while(p < text.length()){


            if(search.charAt(0) == text.charAt(p) ){
                if(compare(search, text, p ))
                    results.add(p);
            }

            p++;
        }

        return results;
    }

    private static boolean compare(String search, String text, int p  ){

        int q =0;
        while(q < search.length()){


            if(search.charAt(q) != text.charAt(p)){
                return false;
            }

            p++;
            q++;
        }


        return true;
    }


}
