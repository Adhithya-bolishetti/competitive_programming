public class Solution {
	public static int maxCost(int[] price, int index, int length, int[][] dp) {
		if(index == 0) return length * price[0];

		if(dp[index][length] != -1) return dp[index][length];
		
		int notPick = maxCost(price, index-1, length, dp);

		int pick = Integer.MIN_VALUE;
		int rodLength = index+1;
		if(length >= rodLength) {
			pick = price[index] + maxCost(price, index, length - rodLength, dp);
		}

		return dp[index][length] = Math.max(pick, notPick);
	}

	public static int cutRod(int price[], int n) {
		int[][] dp = new int[n][n+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=n; j++) {
				dp[i][j] = -1;
			}
		}

		return maxCost(price, n-1, n, dp);
	}
}
// Time complexity : O(n * rod length)
// Space complexity : O(n * rodlength) + O(n) stack space