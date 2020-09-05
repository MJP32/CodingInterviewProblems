package Amazon.Mock;

public class ReverseString {
    public static void main(String[] args) {
//        System.out.println(new ReverseString().reverseStr("abcdefg" ,2));
//        System.out.println(new ReverseString().reverseStr("abcd" ,4));
        System.out.println(new ReverseString().reverseStr("abcdefg" ,8));
    }
    public String reverseStr(String s, int k) {

        int begin =0;
        int end = k;
        String reversed = "";
        for(int i =0;i+k< s.length();i=i+k){

            reversed = reverseInterval(s.substring(begin, end), begin, end);

            s.replace(s.substring(begin, end), reversed);

        }

        return s;



    }
    public String reverseInterval(String s, int begin, int end){


        char[] arr = s.toCharArray();
        char temp = ' ';
        for(int i = begin; i< s.length()/2;i++){

            temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
        }

        return String.valueOf(arr);

    }
}
