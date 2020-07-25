package Leetcode.topic.stg;

public class LC335_SelfCrossing {
    public static void main(String[] args) {
        System.out.println(new LC335_SelfCrossing().isSelfCrossing(new int[]{2,1,1,2}));
    }
    public boolean isSelfCrossing(int[] x) {

        for(int i = 3; i < x.length; i ++){
            if(i >= 3 && x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;

            if(i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;

            if(i >= 5 && x[i - 2] >= x[i - 4] && x[i - 5] + x[i - 1] >= x[i - 3] && x[i - 1] <= x[i - 3] && x[i - 4] + x[i] >= x[i - 2]) return true;
        }

        return false;
    }


}
