import java.util.*;

class Solution {
    public static ArrayList<Integer> countLessEq(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int count = upperBound(b, a[i]);
            list.add(count);
        }

        return list;
    }

    // Returns index of first element > target (upper bound)
    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
// Time complexity : O(nlogm + nlogm)
// Space complexity : O(n)