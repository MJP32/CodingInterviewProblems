package Interviews;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static void main(String[] args) {
        List<String> code = new ArrayList<>();
//        code.add("/*Test program */");
//        code.add("int main()");
//        code.add("{ ");
//        code.add("// variable declaration ");
//        code.add("int a, b, c;");
//        code.add("/* This is a test");
//        code.add("multiline");
//        code.add("comment for ");
//        code.add("testing */");
//        code.add("a = b + c;");
//        code.add("}");

        code.add("a/*comment");
        code.add("line");
        code.add("more_comment*/b");

        String[] stringArray = code.toArray(new String[]{});
        List<String> list = new RemoveComments().removeComments(stringArray);
        for (String ls : list)
            System.out.println(ls);
    }

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();

        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (int i = 0; i < source.length; i++) {

            String line = source[i];
            int j = 0;
            while (j < line.length()) {

                if (j + 1 < line.length() && line.substring(j, j + 2).equals("//")) {
                    break;
                } else if (j + 1 < line.length() && line.substring(j, j + 2).equals("/*")) {
                    inBlock = true;


                } else if (j + 1 < line.length() && line.substring(j, j + 2).equals("*/")) {
                    inBlock = false;

                } else if (!inBlock && line.charAt(j) != '/') {
                    newLine.append(line.charAt(j) + "");
                }


                j++;
            }
            if (!newLine.toString().equals("")){
                result.add(newLine.toString());
                newLine = new StringBuilder();
            }

        }

        return result;
    }
}
