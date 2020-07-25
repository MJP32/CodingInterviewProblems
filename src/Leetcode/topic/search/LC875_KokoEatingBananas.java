package Leetcode.topic.search;

public class LC875_KokoEatingBananas {
    public static void main(String[] args) {
//        System.out.println(new LC875_KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11}, 8 ));
        System.out.println(new LC875_KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    public int minEatingSpeed(int[] piles, int H) {

        int left = 1;
        int right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatInTIme(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canEatInTIme(int[] piles, int k, int h) {

        int hours = 0;
        for (int pile : piles) {
            int div = pile / k;
            hours += div;
            if (pile % k != 0)
                hours++;
        }
        return hours <= h;
    }
}
