class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else {
                    if (j == 0) {
                        temp[j] = dp[j];
                    } else {
                        temp[j] = dp[j] + temp[j - 1]; 
                    }
                }
            }
            dp = temp;
        }

        return dp[n - 1];
    }
}
// Time complexity : O(m*n)
// Space complexity : O(n)