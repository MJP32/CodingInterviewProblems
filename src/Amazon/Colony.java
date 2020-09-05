package Amazon;

import java.util.LinkedList;
import java.util.List;

public class Colony
{
    public static void main(String[] args)
    {
        int cells[] = {1, 0, 0, 0,
                0, 1, 0, 0};
        int k = 1;
        int n = cells.length;
        cellCompete(cells,  k).forEach(v-> System.out.println(v));
    }
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int oldCell[]=new int[states.length];
        for (Integer i = 0; i < states.length ; i++ ){
            oldCell[i] = states[i];
        }
        for (Integer k = 0; k < days ; k++ ){
            for (Integer j = 1; j < oldCell.length - 1 ; j++ ){
                if ((oldCell[j-1] == 1 && oldCell[j+1] == 1) || (oldCell[j-1] == 0 && oldCell[j+1] == 0)){
                    states[j] = 0;
                } else{
                    states[j] = 1;
                }
            }
            if (oldCell[1] == 0){
                states[0] = 0;
            } else{
                states[0] = 1;
            }
            if (oldCell[6] == 0){
                states[7] = 0;
            } else{
                states[7] = 1;
            }
            for (Integer i = 0; i < states.length ; i++ ){
                oldCell[i] = states[i];
            }


        }

        List<Integer> ls = new LinkedList<Integer>();

        for(int i: states){
            ls.add(i);
        }
        return ls;

    }
}
