class Solution {
    public int countPaths(int[][] obstacleGrid, int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        int left = countPaths(obstacleGrid, m-1, n);
        int up = countPaths(obstacleGrid, m, n-1);
        return left + up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        else  if (obstacleGrid[0][0] == 1) return 1;
        else return countPaths(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
    }
}
// Time complexity : O(2^(m*n))
// Space complexity : O(m*n)