class Solution {

    public long sumOfSubarray(int[] arr) {
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        long sum = 0;
        // Previous Less Element
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> gstack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!lstack.isEmpty() && arr[lstack.peek()] > arr[i]) {
                lstack.pop();
            }
            prevLess[i] = lstack.isEmpty() ? -1 : lstack.peek();
            lstack.push(i);
        }

        // Clear stack for reuse
        lstack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!lstack.isEmpty() && arr[lstack.peek()] >= arr[i]) {
                lstack.pop();
            }
            nextLess[i] = lstack.isEmpty() ? n : lstack.peek();
            lstack.push(i);
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            long count = (i - prevLess[i]) * (nextLess[i] - i);
            res = (res + count * arr[i]);
        }

        // Prevoius greater Element
        for (int i = 0; i < n; i++) {
            while (!gstack.isEmpty() && arr[gstack.peek()] < arr[i]) {
                gstack.pop();
            }
            prevGreater[i] = gstack.isEmpty() ? -1 : gstack.peek();
            gstack.push(i);
        }

        // Clear stack for reuse
        gstack.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!gstack.isEmpty() && arr[gstack.peek()] <= arr[i]) {
                gstack.pop();
            }
            nextGreater[i] = gstack.isEmpty() ? n : gstack.peek();
            gstack.push(i);
        }

        long res2 = 0;

        for (int i = 0; i < n; i++) {
            long count = (i - prevGreater[i]) * (nextGreater[i] - i);
            res2 = (res2 + count * arr[i]);
        }

        return res2-res;
    }
    public long subArrayRanges(int[] nums) {
        return sumOfSubarray(nums);
    }
}
// Time Complexity: O(10n) ~ O(n)
// Space Complexity: O(n)