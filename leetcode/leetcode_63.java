class Solution {
    public int countPaths(int[][] obstacleGrid, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;

        int left = countPaths(obstacleGrid, m - 1, n);
        int up = countPaths(obstacleGrid, m, n - 1);

        return left + up;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Base case: if the start or end is blocked, no path exists
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        return countPaths(obstacleGrid, m - 1, n - 1);
    }
}
// Time complexity : O(2^(m*n))
// Space complexity : O(m*n)