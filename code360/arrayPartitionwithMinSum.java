public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int totalSum = 0;

        for(int val : arr) totalSum += Math.abs(val);
        boolean[][] dp = new boolean[n][totalSum+1];
        
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(arr[0] == totalSum) dp[0][arr[0]] = true;
        
        for(int index=1; index<n; index++) {
            for(int target=1; target<=totalSum; target++) {
                boolean notPick = dp[index-1][target];
                boolean pick = false;
                if(arr[index] <= target) {
                    pick = dp[index-1][target - arr[index]];
                }
                dp[index][target] = pick || notPick;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=totalSum; i++) {
            if(dp[n-1][i] == true) {
                min = Math.min(min, Math.abs(totalSum - i - i));
            }
        }
        return min;
    }
}
// Time complexity : O(n*totalSum)
// Space complexity : O(n*totalSum)