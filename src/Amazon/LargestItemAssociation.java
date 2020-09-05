package Amazon;

import java.util.Arrays;
import java.util.List;

public class LargestItemAssociation {
    public static void main(String[] args) {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item1", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item2", "item5") //
        );

        System.out.println(largestItemAssociation(pairs));
    }

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        return null;
    }
    public static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }


}
