class Solution {
    public int countPaths(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int left = countPaths(m-1, n, dp);
        int up = countPaths(m, n-1, dp); 
        return dp[m][n] = left + up;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return countPaths(m-1, n-1, dp);
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n)