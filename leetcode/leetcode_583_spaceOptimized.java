class Solution {
     public int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        
        for(int i=0; i<n; i++) dp[i] = 0;

        for(int index1=1; index1<=m; index1++) {
            int[] temp = new int[n + 1];
            for(int index2=1; index2<=n; index2++) {
                if(word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    temp[index2] = 1 + dp[index2 - 1];
                }
                else {
                    temp[index2] = Math.max(dp[index2], temp[index2 - 1]);
                }
            }
            dp = temp;
        }
        return dp[n];
    }
    public int minDistance(String word1, String word2) {
        int len = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - (2 * len);
    }
}
// Time complexity : O(m * n)
// Space complexity : O(n)