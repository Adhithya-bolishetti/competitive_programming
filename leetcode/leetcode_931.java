class Solution {
    public int pathSum(int[][] matrix, int m, int n) {
        if (n < 0 || n >= matrix.length) return (int) Math.pow(10, 9);;
        if (m == 0) return matrix[m][n];
        
        int left = matrix[m][n] + pathSum(matrix, m - 1, n - 1);
        int up = matrix[m][n] + pathSum(matrix, m - 1, n);
        int right = matrix[m][n] + pathSum(matrix, m - 1, n + 1);
        
        return Math.min(left, Math.min(up, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, pathSum(matrix, n - 1, j));
        }

        return min;
    }
}
// Time complexity : O(3^n)
// Space complexity : O(n)