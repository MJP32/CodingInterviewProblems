package Leetcode.topic.array;

public class LC941_MountainArray {
    public static void main(String[] args) {
        //System.out.println(new LC941_MountainArray().validMountainArray(new int[]{1,4,5,7, 10, 4, 3, 1 }));
        //System.out.println(new LC941_MountainArray().validMountainArray(new int[]{1,4,5,7, 9 }));
        //System.out.println(new LC941_MountainArray().validMountainArray(new int[]{0,1,2,4,2,1 }));
        System.out.println(new LC941_MountainArray().validMountainArray(new int[]{0,3,2,1 }));

    }
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
}
