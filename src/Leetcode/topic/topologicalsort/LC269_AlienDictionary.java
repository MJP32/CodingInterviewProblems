package Leetcode.topic.topologicalsort;

public class LC269_AlienDictionary {
    public static void main(String[] args) {
        String[] words =new String[]{
                    "wrt",
                    "wrf",
                    "er",
                    "ett",
                    "rftt"
        };

        /*
        0  1 2 3 4 5 6 7 8 9  10 11 12 13 14 15 16 17 18 19 20 21  22  23  24   25
        a  b c d e f g h i j  k   l  m  n  o  p  q  r  s  t  u  v   w   x   y    z



        [22] ->  17, 19
        [17] ->  19
        [5]  ->  17
        [5]  ->  19, 19
        [17] ->  6, 19, 19



        4:  0
        5:  0
        17: 0
        19: 0
        22: 0



        */

        System.out.println(new LC269_AlienDictionary().alienOrder(words));
    }
    public String alienOrder(String[] words) {




        return "";
    }
}
