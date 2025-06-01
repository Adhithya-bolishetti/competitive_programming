class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) dp[i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[j];
                int left = (j > 0) ? matrix[i][j] + dp[j - 1] : (int) 1e9;
                int right = (j < n - 1) ? matrix[i][j] + dp[j + 1] : (int) 1e9;
                temp[j] = Math.min(down, Math.min(left, right));
            }
            dp = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[j]);
        }

        return min;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)