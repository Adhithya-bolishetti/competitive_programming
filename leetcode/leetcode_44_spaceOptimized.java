
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] dp = new boolean[m + 1];

        dp[0] = true;

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int k = 0; k < j; k++) { 
                if (p.charAt(k) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            boolean[] temp = new boolean[m + 1];

            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    temp[j] = dp[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    temp[j] = dp[j] || temp[j - 1];
                } else {
                    temp[j] = false;
                }
            }
            dp = temp;
        }

        return dp[m];
    }
}
// Time complexity : O(n * m)
// Space complexity : O(m)