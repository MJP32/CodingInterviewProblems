package Leetcode.zap.todo.finish;

public class LC541_ReverseString2 {
    public static void main(String[] args) {
        System.out.println(new LC541_ReverseString2().reverseStr("abcdefg", 2 ));
    }
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
