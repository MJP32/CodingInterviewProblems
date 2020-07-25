package bytebybyte.module3;

public class TowersOfHanoi {
    public static void main(String[] args) {
        System.out.println(moveCount(4));
    }
    public static int moveCount(int n){
        if(n ==1){
            return 1;
        }
        return 2 * moveCount(n-1) +1;
    }
}
