package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonFreshPromotionCode {

    public static int isCustomerWinner(List<String> shoppingList, List<List<String>> codeList)
    {
        //checking for edge cases
        if(codeList.size() == 0)
            return 1;
        if(shoppingList == null || shoppingList.size() == 0)
            return  0;

        int codeListIdx = 0;
        List<String> code = codeList.get(codeListIdx);
        // we keep 2 pointers for iterating shoppingList
        // Each time if there is a mismatch, itemEnd starts checking from itemBegin + 1
        int codeIdx = 0, itemBegin = 0, itemEnd = 0;

        while(itemEnd < shoppingList.size())
        {
            // since "anything" has to be something, it cannot be "nothing"
            if(code.get(codeIdx).equals("anything") && (shoppingList.get(itemEnd).equals("") || shoppingList.get(itemEnd).equals(" ")))
                return 0;

            // if there is "anything" in code or matches with shopping item, we move ahead to check next shopping cart item and next code value
            if(code.get(codeIdx).equals("anything") || shoppingList.get(itemEnd).equals(code.get(codeIdx)))
            {
                codeIdx++;
                itemEnd++;
            }
            else
            {
                // else if there is no match, we begin checking the shoppingList again leaving first checked item and check the next item with the first code value again.
                // eg : CodeList = [[anything, anything, anything, apple],[...]]  ShoppingList = [orange, apple, banana, orange, apple, orange, ...]
                // Here, CL[0] is anything so check next item with next code; next CL[1] is anything so check next; next CL[2] is also anything so check next. But CL[3] is not equal to SL[3], so now we check CL[0] again with SL[1] in the hope that CL items might match with the SL items ahead.
                codeIdx = 0;
                itemEnd = ++itemBegin;
            }

            // Checking if we are done with a code in CodeList, we move to next code.
            // If we reach at the end of CodeList successfully, it means success as there are no more codes to check.
            if (codeIdx == code.size())
            {
                codeListIdx++;

                if (codeListIdx == codeList.size())
                {
                    return 1;
                }
                else
                {
                    // Else we update code value with new list present at new CodeList index
                    // And since we found a code match in our Shopping list, we update itemBegin counter to point next to matched item index
                    code = codeList.get(codeListIdx);
                    codeIdx = 0;
                    itemBegin = itemEnd;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args)
    {
        List<List<String>> codeList1 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("banana", "anything", "banana")));
        List<String> shoppingList1 = new ArrayList<String>(Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana"));

        System.out.println("Result1 = " + isCustomerWinner(shoppingList1, codeList1));

        List<List<String>> codeList2 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("banana", "anything", "banana")));
        List<String> shoppingList2 = new ArrayList<String>(Arrays.asList("apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"));

        System.out.println("Result2 = " + isCustomerWinner(shoppingList2, codeList2));

        List<List<String>> codeList3 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("banana", "anything", "banana")));
        List<String> shoppingList3 = new ArrayList<String>(Arrays.asList("banana", "orange", "banana", "apple", "apple"));

        System.out.println("Result3 = " + isCustomerWinner(shoppingList3, codeList3));

        List<List<String>> codeList4 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("banana", "anything", "banana")));
        List<String> shoppingList4 = new ArrayList<String>(Arrays.asList("apple", "apple", "banana", "orange", "banana"));

        System.out.println("Result4 = " + isCustomerWinner(shoppingList4, codeList4));

        List<List<String>> codeList5 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("apple", "apple", "banana")));
        List<String> shoppingList5 = new ArrayList<String>(Arrays.asList("apple", "apple", "apple", "banana"));

        System.out.println("Result5 = " + isCustomerWinner(shoppingList5, codeList5));

        List<List<String>> codeList6 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "anything"), Arrays.asList("anything", "anything", "banana")));
        List<String> shoppingList6 = new ArrayList<String>(Arrays.asList("apple", "apple", "orange", "banana", "orange", "banana"));
        System.out.println("Result6 = " + isCustomerWinner(shoppingList6, codeList6));

        List<List<String>> codeList7 = new ArrayList<>(Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList
                ("anything", "anything", "banana")));
        List<String> shoppingList7 = new ArrayList<String>(Arrays.asList("apple", "apple", "orange", "banana",
                "orange", "banana"));



        System.out.println("Result7 = " + isCustomerWinner(shoppingList7, codeList7));
    }
}