package bytebybyte.module3.hw;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(320, 104));
    }
    public static int gcd(int a, int b){


        //switch arguments if b bigger than a
        //if(b>a)
          //  return gcd(b,a);


        if(b==0)
            return a;



        return gcd(b, a%b);
    }
}
