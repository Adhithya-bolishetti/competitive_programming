class Solution {
    public static int longestPalindromeSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<m; i++) dp[i][0] = 0;
        for(int i=0; i<n; i++) dp[0][i] = 0;

        for(int index1=1; index1<=m; index1++) {
            for(int index2=1; index2<=n; index2++) {
                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[m][n];
    }
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return longestPalindromeSubsequence(s, reversed);
    }
}
// Time complexity : O(n * n)
// Space complexity : O(n * n)