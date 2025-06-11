class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        
        for(int i=0; i<n; i++) dp[i] = 0;

        for(int index1=1; index1<=m; index1++) {
            int[] temp = new int[n + 1];
            for(int index2=1; index2<=n; index2++) {
                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
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
}
// Time complexity : O(n * m)
// Space complexity : O(n)