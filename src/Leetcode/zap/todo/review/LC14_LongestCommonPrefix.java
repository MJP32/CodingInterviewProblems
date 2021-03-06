package Leetcode.zap.todo.review;

public class LC14_LongestCommonPrefix {
    public static void main(String[] args) {
        LC14_LongestCommonPrefix lc14 = new LC14_LongestCommonPrefix();
        System.out.println(lc14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0)
            return "";
        String prefix = strs[0];
        for(int i =1; i< strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
