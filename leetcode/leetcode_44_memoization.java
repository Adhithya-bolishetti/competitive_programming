import java.util.Arrays;

class Solution {
    public int isMatched(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (i >= 0 && j < 0) return 0;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            return dp[i][j] = isMatched(s, p, i - 1, j - 1, dp);
        }

        if (p.charAt(j) == '*') {
            return dp[i][j] = (isMatched(s, p, i - 1, j, dp) == 1 || isMatched(s, p, i, j - 1, dp) == 1) ? 1 : 0;
        }

        return dp[i][j] = 0;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, -1);

        return isMatched(s, p, n - 1, m - 1, dp) == 1;
    }
}
// Time complexity : O(n * m)
// Space complexity : O(n * m) + stack space