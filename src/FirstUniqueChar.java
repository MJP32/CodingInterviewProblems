import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String[] args) {

    }
    public int firstUniquChar(String s) {

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {


                map.put(s.charAt(i), -1);

            } else {
                map.put(s.charAt(i), i);

            }
        }


        int min = Integer.MAX_VALUE;

        for (Character c : map.keySet()) {
            if (map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }


        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
