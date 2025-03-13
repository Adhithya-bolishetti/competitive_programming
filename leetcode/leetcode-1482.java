class Solution {
    public boolean isPossible(int[] arr, int mid, int n, int k, int m) {
        int count = 0, bouquets = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; // Reset after forming one bouquet
                }
            } else {
                count = 0; // Reset if bloomDay[i] > mid
            }
            if (bouquets >= m) return true; // If enough bouquets are formed, return early
        }
        
        return bouquets >= m; // Final check
    }

    public int minValue(int[] arr, int n) {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            m = Math.min(m, arr[i]);
        }
        return m;
    }

    public int maxValue(int[] arr, int n) {
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, arr[i]);
        }
        return m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long)m * k) return -1; // Early check
        
        int low = minValue(bloomDay, n);
        int high = maxValue(bloomDay, n);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, n, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
