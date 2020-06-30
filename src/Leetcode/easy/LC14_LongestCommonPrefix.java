package Leetcode.easy;

public class LC14_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LC14_LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix;
        }

        int index = 0;
        for (char c : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += c;
            index++;
        }


        return longestCommonPrefix;
    }
}
