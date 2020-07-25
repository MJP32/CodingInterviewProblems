package Leetcode.easy;

public class LC1160_FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        System.out.println(new LC1160_FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"cat","bt",
                "hat","tree"}, "atach"));
    }
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for (char ch : chars.toCharArray()) {
            arr[ch - 'a']++;
        }
        int ans =0;
        for (String s : words) {
            int[] clone = arr.clone();

            for (int i = 0;i<s.length();i++) {
                clone[s.charAt(i) - 'a']--;
                if (clone[s.charAt(i) - 'a'] < 0) {
                    break;
                }
                if(i==s.length()-1){
                    ans+=s.length();
                }
            }
        }
        return ans;
    }
}
