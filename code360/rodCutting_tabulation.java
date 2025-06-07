public class Solution {
	public static int cutRod(int price[], int n) {
		int[][] dp = new int[n][n+1];
		
		for(int i=0; i<=n; i++) dp[0][i] = i * price[0];

		for(int index=1; index<n; index++) {
			for(int length=0; length<=n; length++) {

				int notPick = dp[index-1][length];

				int pick = Integer.MIN_VALUE;
				int rodLength = index+1;
				if(length >= rodLength) {
					pick =  price[index] +  dp[index][length - rodLength];
				}
				dp[index][length] = Math.max(pick, notPick);
			}
		}

		return dp[n-1][n];
	}
}
// Time complexity : O(n * rod length)
// Space complexity : O(n * rod length)