import java.util.*;

class Solution {
    public int countPaths(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) return dp[m][n];

        int left = countPaths(obstacleGrid, m - 1, n, dp);
        int up = countPaths(obstacleGrid, m, n - 1, dp);
        return dp[m][n] = left + up;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countPaths(obstacleGrid, m - 1, n - 1, dp);
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n)