import java.util.*;

public class Main
{
    public static int houseRob(int[] arr, int index, int[] dp) {
        if(index == 0) return arr[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = arr[index] + houseRob(arr, index-2, dp);
        int notPick = houseRob(arr, index -1, dp);
        return dp[index] =  Math.max(pick, notPick);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
		    arr[i] = sc.nextInt();
		}
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		int ans = houseRob(arr, n-1, dp);
		System.out.print(ans);
	}
}
// Time complexity : O(n)
// Space complexity : O(n) dp + O(n) stack