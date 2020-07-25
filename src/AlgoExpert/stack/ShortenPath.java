package AlgoExpert.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenPath {
    public static void main(String[] args) {
//        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(shortenPath("/../"));
    }
    public static String shortenPath(String path) {
        // Write your code here;
        boolean startsWithPath = path.charAt(0)=='/';

        String[] tokens = path.split("/");

        List<String> filteredaTokens = Arrays.asList(tokens).stream().filter(token ->isImportantToken(token)).collect
                (Collectors.toList());


        //filteredaTokens.forEach(k-> System.out.println(k));

        Stack<String> stack = new Stack<>();

        if(startsWithPath)
            stack.add("");
        for(String token : filteredaTokens){
            if(token.equals("..") ){
                if(stack.size() ==0 || stack.get(stack.size()-1).equals(".."))
                    stack.add(token);
                else if(!stack.get(stack.size()-1).equals("")){
                    stack.remove(stack.size()-1);
                }
            }
            else {
                stack.add(token);
            }

        }

        if(stack.size()==1 && stack.get(0).equals(""))
            return "/";



        return String.join("/", stack);
    }

    public static boolean  isImportantToken(String token) {
        // Write your code here;
        return token.length() >0 && !token.equals(".");
    }
}
