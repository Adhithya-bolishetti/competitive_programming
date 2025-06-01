class Solution {
    public int minimumPathSum(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + minimumPathSum(triangle, i+1, j, dp);
        int diagonal = triangle.get(i).get(j) + minimumPathSum(triangle, i+1, j+1, dp);
        return dp[i][j] =  Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumPathSum(triangle, 0, 0, dp);
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)