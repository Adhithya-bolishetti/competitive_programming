public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] dp = new int[w + 1];

        for(int i=0; i<=w; i++) dp[i] = profit[0] * (i / weight[0]);

        for(int i=1; i<n; i++) {
            int[] temp = new int[w+1];
            for(int j=0; j<=w; j++) {

                int notPick = dp[j];

                int pick = Integer.MIN_VALUE;
                if(j >= weight[i]) {
                    pick = profit[i] + temp[j - weight[i]];
                }

                temp[j] = Math.max(pick, notPick);
            }
            dp = temp;
        }
        return dp[w];
    }
}
// Time complexity : O(n * w)
// Space complexity : O(w)