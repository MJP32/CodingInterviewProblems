package Leetcode.topic.recursion;

public class LC97_InterleavingString {
    static boolean found = false;
    public static void main(String[] args) {
//        new LC97_InterleavingString().isInterleave("ab","cd", "acbd");
        //new LC97_InterleavingString().isInterleave("a","", "a");
        //System.out.println(found);
        new LC97_InterleavingString().isInterleave("a","b", "a");
        System.out.println(found);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.equals("")&& s2.equals("")&&s3.equals("")){
            return true;
        }
        return isInterleave(s1, s2, s3, 0,0, new StringBuilder());

    }

    public boolean isInterleave(String s1,String s2,String s3, int i , int j, StringBuilder path){

        if(i > s1.length() && j >s2.length()){
            return false;
        }
        if(path.toString().equals(s3)){
            found = true;
        }
        //System.out.println(path.toString());


        if (i < s1.length()) {
            path.append(s1.charAt(i));
            isInterleave(s1, s2,s3, i+1, j, path);
            path.setLength(path.length()-1);

        }
        if (j < s2.length()) {
            path.append(s2.charAt(j));
            isInterleave(s1, s2,s3, i, j+1, path);
            path.setLength(path.length()-1);

        }
        return found;
    }
}
