class Solution {
    public int findElement(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i - 1]);
        }

        minRight[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], arr[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= maxLeft[i] && arr[i] <= minRight[i]) {
                return arr[i];
            }
        }

        return -1;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)