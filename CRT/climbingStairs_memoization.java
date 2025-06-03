import java.util.*;

public class Main
{
    public static int climbingStairs(int n, int[] dp) {
        if(n == 0) return 1;
        if(n == 1 || n == 2) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbingStairs(n-1, dp) + climbingStairs(n-2, dp);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		int ans = climbingStairs(n, dp);
		System.out.print(ans);
	}
}
// Time complexity : O(n)
// Space complexity : O(n) dp + O(n) stack space