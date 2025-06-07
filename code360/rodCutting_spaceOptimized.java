public class Solution {
	public static int cutRod(int price[], int n) {
		int[] dp = new int[n+1];
		
		for(int i=0; i<=n; i++) dp[i] = i * price[0];

		for(int index=1; index<n; index++) {
			int[] temp = new int[n+1];
			for(int length=0; length<=n; length++) {

				int notPick = dp[length];

				int pick = Integer.MIN_VALUE;
				int rodLength = index+1;
				if(length >= rodLength) {
					pick =  price[index] +  temp[length - rodLength];
				}
				temp[length] = Math.max(pick, notPick);
			}
			dp = temp;
		}

		return dp[n];
	}
}
// Time complexity : O(n * rod length)
// Space complexity : O(rod length)