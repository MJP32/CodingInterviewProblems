package AlgoExpert.recursion;

import java.util.HashMap;
import java.util.Map;

public class NthFibbonacci {
    public static void main(String[] args) {
        System.out.println(getNthFib(6));
       System.out.println(getNthFibMemo(6));
//        System.out.println(getNthFibIter(6));
    }

    private static int getNthFibIter(int n) {




        return 0;
    }

    public static int getNthFib(int n) {
        //System.out.println("->"+n);
        if(n == 1){
            //System.out.println("ret 0 ");
            return 0;
        }
        else if(n ==2){
            //System.out.println("ret 1");
            return 1;
        }
        return getNthFib(n-2) +getNthFib(n-1) ;
    }

    public static int getNthFibMemo(int n) {
        Map<Integer, Integer> mempMap = new HashMap<>();
        mempMap.put(1, 0);
        mempMap.put(2, 1);
        return getNthFibMemo(n, mempMap ) ;
    }

    private static int getNthFibMemo(int n, Map<Integer, Integer> memoMap) {
        if(memoMap.containsKey(n)){
            return memoMap.get(n);
        }
        else{
            memoMap.put(n, getNthFibMemo(n-2, memoMap) + getNthFibMemo(n-1,memoMap));
            return memoMap.get(n);
        }
    }




}
