package bytebybyte.module6;

public class CountUniqueBST {
    public static void main(String[] args) {
        System.out.println(new CountUniqueBST().countBST(3));
    }
    public int countBST(int n) {
        System.out.println("n = " + n);
        if(n <=1)
            return 1;

        int count =0;

        for(int i =0; i< n;i++){
            System.out.println("\ti = " + i );
            count +=countBST(i) * countBST(n-i-1);
            System.out.println("\t\tcount = " +count);

        }

        return count;
    }
}
