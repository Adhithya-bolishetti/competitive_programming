public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for(int i=0; i<=w; i++) dp[0][i] = profit[0] * (i / weight[0]);

        for(int i=1; i<n; i++) {
            for(int j=0; j<=w; j++) {

                int notPick = dp[i-1][j];

                int pick = Integer.MIN_VALUE;
                if(j >= weight[i]) {
                    pick = profit[i] + dp[i][j - weight[i]];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][w];
    }
}
