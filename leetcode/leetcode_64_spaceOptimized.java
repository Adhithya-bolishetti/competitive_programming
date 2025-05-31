class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for(int i=1; i<n; i++) dp[i] = dp[i-1] + grid[0][i];

        for(int i=1; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(j == 0) {
                    temp[0] = grid[i][0] + dp[j];
                }
                else {
                    temp[j] = grid[i][j] + Math.min(temp[j-1], dp[j]);
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
// Time complexity : O(m*n)
// Space complexity : O(n)