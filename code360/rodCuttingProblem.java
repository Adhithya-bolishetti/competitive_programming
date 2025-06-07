public class Solution {
	public static int maxCost(int[] price, int index, int length) {
		if(index == 0) return length * price[0];
		int notPick = maxCost(price, index-1, length);
		int pick = Integer.MIN_VALUE;
		int rodLength = index+1;
		if(length >= rodLength) {
			pick = price[index] + maxCost(price, index, length - rodLength);
		}
		return Math.max(pick, notPick);
	}

	public static int cutRod(int price[], int n) {
		return maxCost(price, n-1, n);
	}
}
// Time complexity : O(n * rodLength)
// Space complexity : O(n) stack space