package Leetcode.easy;

public class LC1189_MaximumNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(new LC1189_MaximumNumberOfBalloons().maxNumberOfBalloons("loonbalxballpoon"));
    }
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for(int i=0; i < text.length(); i++){
            count[text.charAt(i)- 'a']++;
        }
        //b
        int min = count[1];
        //a
        min = Math.min(min, count[0]);

        //l
        min = Math.min(min, count[11]/2);

        //0
        min  = Math.min(min, count[14]/2);

        //n
        min = Math.min(min, count[13]);

        return min;
    }
}
