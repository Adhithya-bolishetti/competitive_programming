class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        // Previous Less Element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for reuse
        stack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long res = 0;
        int MOD = (int)1e9 + 7;

        for (int i = 0; i < n; i++) {
            long count = (i - prevLess[i]) * (nextLess[i] - i) % MOD;
            res = (res + count * arr[i]) % MOD;
        }

        return (int) res;
    }
}
