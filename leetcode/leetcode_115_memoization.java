class Solution {
    public int countSubsequences(String s, String t, int i, int j, int[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = countSubsequences(s, t, i-1, j-1, dp) + countSubsequences(s, t, i-1, j, dp);
        }
        return dp[i][j] = countSubsequences(s, t, i-1, j, dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int[] row : dp) Arrays.fill(row, -1);

        return countSubsequences(s, t, n-1, m-1, dp);
    }
}
// Time complexity : O(n * m)
// Space complexity : O(n * m) + O(n * m) stack space