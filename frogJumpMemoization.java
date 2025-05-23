import java.util.*;

public class Main {
    public static int minEnergy(int[] arr, int index, int[] dp) {
        if (index == 0) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        int left = minEnergy(arr, index - 1, dp) + Math.abs(arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;

        if (index > 1) {
            right = minEnergy(arr, index - 2, dp) + Math.abs(arr[index] - arr[index - 2]);
        }

        return dp[index] = Math.min(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = minEnergy(arr, n - 1,dp);
        System.out.print(ans);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)