package FB;

public class EncryptedWords {
    public static void main(String[] args) {
        System.out.println(new EncryptedWords().findEncryptedWord("abc"));
        System.out.println(new EncryptedWords().findEncryptedWord( "abcd"));
        System.out.println(new EncryptedWords().findEncryptedWord( "abcxcba"));

        //x abc cba
        //
    }
    String findEncryptedWord(String s) {
        // Write your code here
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);

        return findEncryptedWord(sb, result).toString();
    }

    private StringBuilder findEncryptedWord(StringBuilder sb, StringBuilder result) {

        if(sb.length()<3){
            return result.append(sb);
        }

        int mid =0;
        if(sb.length()/2 %2==1){
            mid = sb.length()/2;
        }
        else{
            mid = sb.length()/2 -1;
        }

        result.append(sb.charAt(mid));
        result.append(sb.charAt(mid-1));
        result.append(sb.charAt(mid+1));

        sb.deleteCharAt(mid+1);
        sb.deleteCharAt(mid);
        sb.deleteCharAt(mid-1);

        return findEncryptedWord(sb, result);
    }
}
