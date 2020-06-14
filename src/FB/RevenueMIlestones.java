package FB;

import java.util.Arrays;

public class RevenueMIlestones {
    public static void main(String[] args) {

        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        System.out.println(Arrays.toString(new RevenueMIlestones().getMilestoneDays(revenues_1, milestones_1)));
        System.out.println(Arrays.toString(new RevenueMIlestones().getMilestoneDays(revenues_2, milestones_2)));
    }

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] days = new int[milestones.length];

        int total = 0;
        int i = 0;
        while (i < revenues.length) {
            total += revenues[i];
            int j = 0;
            while (j < milestones.length ) {
                if (days[j] == 0 && total >= milestones[j])
                    days[j] = i + 1;
                j++;
            }
            i++;
        }
        return days;
    }
}
