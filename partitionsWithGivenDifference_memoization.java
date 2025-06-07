import java.util.* ;
import java.io.*; 
public class Solution {
	 public static int partition(int[] arr, int index, int k, int[][] dp) {
        if(index == 0) {
			if(k == 0 && arr[0] == 0) return 2;
			if(k == 0 || arr[0] == k) return 1;
			return 0;
		}
        if(dp[index][k] != -1) return dp[index][k];

        int notPick = partition(arr, index-1, k, dp);
        int pick = 0;
        if(k >= arr[index]) pick = partition(arr, index-1, k-arr[index], dp);

        return dp[index][k] = (notPick + pick) % 1000000007;
    }

	public static int countPartitions(int n, int d, int[] arr) {
		int sum = 0;
		for(int val : arr) sum += val;

		if(sum - d < 0) return 0;
		if((sum - d) % 2 == 1) return 0;

		int s2 = (sum - d) / 2;
		int[][] dp = new int[n][s2+1];

		for(int row[]: dp) Arrays.fill(row,-1);

		return partition(arr, n-1, s2, dp);
	}
}
// Time complexity : O(n * s2)
// Space complexity : O(n * s2)