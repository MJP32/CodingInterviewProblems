package bytebybyte.module1;



import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubstring {
    public static void main(String[] args) {
        substrings("1234").forEach(k -> System.out.println(k));


        //List<List<Integer>> result = findSubsets(new int[]{1, 3});
        //System.out.println("Here is the list of subsets: " + result);


        System.out.println(substrings(new int[]{1,2,3}));
    }




    public static List<List<Integer>> substrings(int[] nums){
        List<List<Integer>> allResults = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = i+1; j <= nums.length-1 ; j++) {
                result.add(nums[i]);
                result.add(nums[j]);
            }
            allResults.add(result);
        }
        return allResults;


    }
    public static List<String> substrings(String s){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                result.add(s.substring(i, j));

            }
        }

        return result;
    }


    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }

        }


        return subsets;
    }
}
