class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0) == (divisor >= 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += 1 << count;
            n -= d << count;
        }

        return sign ? ans : -ans;
    }
}
