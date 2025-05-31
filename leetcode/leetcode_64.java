class Solution {
    public int pathSum(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return Integer.MAX_VALUE;

        int left = pathSum(grid, m - 1, n);
        int up = pathSum(grid, m, n - 1);

        return grid[m][n] + Math.min(left, up);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return pathSum(grid, m - 1, n - 1);
    }
}
// Time complexity : O(2^(m*n))
// Space complexity : O(m*n)