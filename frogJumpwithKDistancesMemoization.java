import java.util.*;

public class Main {
    public static int minEnergy(int[] arr, int index, int k, int[] dp) {
        if (index == 0) return 0;
        if(dp[index] != -1) return dp[index];
        int mmSteps = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++) {
             if (index - j >= 0) {
                int jump = minEnergy(arr,index - j, k, dp) + Math.abs(arr[index] - arr[index - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }

        return dp[index] = mmSteps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = minEnergy(arr, n - 1, k, dp);
        System.out.print(ans);
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n)