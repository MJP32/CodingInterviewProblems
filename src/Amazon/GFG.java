package Amazon;

import java.util.*;

class GFG {

    // Function to find consecutive ranges
    static List<String>
    consecutiveRanges(int[] a)
    {
        int length = 1;
        List<String> list
                = new ArrayList<String>();

        // If the array is empty,
        // return the list
        if (a.length == 0) {
            return list;
        }

        // Traverse the array from first position
        for (int i = 1; i <= a.length; i++) {

            // Check the difference between the
            // current and the previous elements
            // If the difference doesn't equal to 1
            // just increment the length variable.
            if (i == a.length
                    || a[i] - a[i - 1] != 1) {

                // If the range contains
                // only one element.
                // add it into the list.
                if (length == 1) {
                    list.add(
                            String.valueOf(a[i - length]));
                }
                else {

                    // Build the range between the first
                    // element of the range and the
                    // current previous element as the
                    // last range.
                    list.add(a[i - length]
                            + " -> " + a[i - 1]);
                }

                // After finding the first range
                // initialize the length by 1 to
                // build the next range.
                length = 1;
            }
            else {
                length++;
            }
        }

        return list;
    }

    // Driver Code.
    public static void main(String args[])
    {

        // Test Case 1:
        int[] arr1 = { 1, 2, 3, 6, 7 };
        System.out.print(consecutiveRanges(arr1));
        System.out.println();

        // Test Case 2:
        int[] arr2 = { -1, 0, 1, 2, 5, 6, 8 };
        System.out.print(consecutiveRanges(arr2));
        System.out.println();

        // Test Case 3:
        int[] arr3 = {100, -1, 3, 4, 5, 20, 21, 25,99 };
        System.out.print(consecutiveRanges(arr3));
    }
}
