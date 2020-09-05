package Amazon;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(new Gcd().generalizedGCD(5 , new int[]{2,4,6,8,10}));
    }
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE

        int result = arr[0];
        for(int i =1; i < arr.length;i++){
            result = gcd(arr[i],result);
        }
        return result;
    }

    private int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a, a);
    }
}
