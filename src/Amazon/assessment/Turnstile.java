package Amazon.assessment;

import java.util.*;

public class Turnstile {
    public static void main(String args[]) {

        int numCustomers = 5;
        int[] arrTime = {0, 1, 1, 3, 3};
        int[] direction = {0, 1, 0, 0, 1};
// Output: [0, 2, 1, 4, 3]

        Queue<Integer> entryQueue = new ArrayDeque<>();
        Queue<Integer> exitQueue = new ArrayDeque<>();

        Map<Integer, List<Integer>> timeCustomerMap = new HashMap<>();

        for (int i = 0; i < arrTime.length; i++) {
            List<Integer> customers = timeCustomerMap.getOrDefault(arrTime[i], new ArrayList<>());
            customers.add(i);
            timeCustomerMap.put(arrTime[i], customers);
        }

        int[] timeForEachCustomer = new int[numCustomers];
        int total = 0;
        Integer prev = null;
        int time = 0;
        while (total != numCustomers) {

            List<Integer> cust = timeCustomerMap.getOrDefault(time, new ArrayList<>());
            if (cust.size() > 0) {
                for (int i : cust) {
                    if (direction[i] == 0) {
                        entryQueue.add(i);
                    } else if (direction[i] == 1) {
                        exitQueue.add(i);
                    }
                }
            }

            boolean turnstileUsed = false;
            // priority check
            if (prev == null || prev == 1 || entryQueue.isEmpty()) {
                if (!exitQueue.isEmpty()) {
                    timeForEachCustomer[exitQueue.poll()] = time;
                    prev = 1;
                    turnstileUsed = true;
                }
            }
            if (!turnstileUsed) {
                if (!entryQueue.isEmpty()) {
                    timeForEachCustomer[entryQueue.poll()] = time;
                    prev = 0;
                    turnstileUsed = true;
                }
            }

            if (!turnstileUsed) {
                prev = null;
            } else {
                total += 1;
            }

            time += 1;
        }

        System.out.println(Arrays.toString(timeForEachCustomer));

    }
}

