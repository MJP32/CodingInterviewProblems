package Interviews;

public class PrintSquare {
    public static void main(String[] args) {
        printSquare(10);
    }
    public static  void printSquare(int n ){
        int first = 1;
        int multiple = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(first * j >=10)
                    System.out.print(first * j);
                else
                    System.out.print(" "+first * j);
            }
            first++;
            System.out.println();
        }

    }
}
