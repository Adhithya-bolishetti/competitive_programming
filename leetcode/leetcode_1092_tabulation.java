class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<m; i++) dp[i][0] = 0;
        for(int i=0; i<n; i++) dp[0][i] = 0;

        for(int index1=1; index1<=m; index1++) {
            for(int index2=1; index2<=n; index2++) {
                if(str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                    sb.append(str1.charAt(i-1));
                    i--;
            }
            else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
}
// Time complexity : O(n * m)
// Space complexity : O(n * m)