import java.util.*;

public class Main {
    public static int minEnergy(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    mmSteps = Math.min(mmSteps, jump);
                }
            }
            dp[i] = mmSteps;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       
        int[] arr = new int[n];     

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();    

        int ans = minEnergy(arr, k);
        System.out.print(ans);
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n)