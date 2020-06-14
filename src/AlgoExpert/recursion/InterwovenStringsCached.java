package AlgoExpert.recursion;

public class InterwovenStringsCached {
    public static void main(String[] args) {
        System.out.println(interweavingStrings("aaa","aaaf","aaafaaa"));
    }
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if(three.length() != one.length()+two.length()){
            return false;
        }
        boolean[][] cache = new boolean[one.length()+1][two.length()+1];

        return isInterwoven(one,two,three, 0,0, cache);
    }

    private static boolean isInterwoven(String one, String two, String three, int i, int j, boolean[][]cache) {

        if(cache[i][j] == true){
            return true;
        }

        int k = i +j;

        if(k == three.length()){
            return true;
        }

        if(i < one.length() && one.charAt(i) == three.charAt(k))
            cache[i][j] = isInterwoven(one, two, three, i+1, j, cache);
            if(cache[i][j])
                return true;

        if(j < two.length() && two.charAt(j) == three.charAt(k)){
            cache [i][j] = isInterwoven(one,two,three,i,j+1, cache);
            if(cache[i][j])
                return true;
        }

        cache[i][j] = false;
        return false;

    }
}
