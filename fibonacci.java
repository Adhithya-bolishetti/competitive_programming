import java.util.*;
class Main{
    public static int fibonacci(int n,int[] dp) {
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibonacci(n-1,dp)+fibonacci(n-2,dp);
    }
    public static void main(String args[]) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = fibonacci(n,dp);
        System.out.print(ans);
    }
}
//Time complexity : O(n)
//Space complexity : O(n) + O(n) ~ O(n)