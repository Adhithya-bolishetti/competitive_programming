import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
		    dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.print(dp[n]);
	}
}
// Time complexity : O(n)
// Space complexity : O(n) dp