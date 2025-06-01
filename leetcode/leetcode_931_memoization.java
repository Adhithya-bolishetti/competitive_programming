class Solution {
    public int pathSum(int[][] matrix, int m, int n, int[][] dp) {
        if (n < 0 || n >= matrix.length) return (int) 1e9;
        if (m == 0) return matrix[m][n];
        if(dp[m][n] != -1) return dp[m][n];
        
        int left = matrix[m][n] + pathSum(matrix, m - 1, n - 1, dp);
        int up = matrix[m][n] + pathSum(matrix, m - 1, n, dp);
        int right = matrix[m][n] + pathSum(matrix, m - 1, n + 1, dp);
        
        return dp[m][n] = Math.min(left, Math.min(up, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int j = 0; j < n; j++) {
            min = Math.min(min, pathSum(matrix, n - 1, j, dp));
        }

        return min;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)