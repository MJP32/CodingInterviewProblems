package AlgoExpert.recursion;

public class InterwovenStrings {
    public static void main(String[] args) {
        System.out.println(interweavingStrings("aaa","aaaf","aaafaaa"));
    }
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if(three.length() != one.length()+two.length()){
            return false;
        }
        return isInterwoven(one,two,three, 0,0);
    }

    private static boolean isInterwoven(String one, String two, String three, int i, int j) {
        int k = i +j;

        if(k == three.length()){
            return true;
        }

        if(i < one.length() && one.charAt(i) == three.charAt(k))
            if(isInterwoven(one, two, three, i+1, j))
                return true;

        if(j < two.length() && two.charAt(j) == three.charAt(k)){
            if(isInterwoven(one,two,three,i,j+1))
                return true;
        }

        return false;

    }
}
