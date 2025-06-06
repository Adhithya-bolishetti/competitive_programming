import java.util.*;
import java.io.*;

public class Solution {

    private static int numberOfWays(int i, int sum, int n, int[] num, int[][] dp) {
        // Not a valid case as sum becomes greater than what we want.
        if (sum < 0) {
            return 0;
        }

        // If we traverse the whole array.
        if (i == n) {
            // Sum becomes equal to the target sum.
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        // Return the value if we already have calculated.
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        // If we take the ith element.
        int ans = numberOfWays(i + 1, sum - num[i], n, num, dp);
        // If we do not take the ith element.
        ans = (ans + numberOfWays(i + 1, sum, n, num, dp));

        // Store the answer in dp and then return.
        dp[i][sum] = ans % 1000000007;
        return dp[i][sum];
    }

    public static int findWays(int num[], int tar) {

        int n = num.length;
        int dp[][] = new int[n][tar + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= tar; j++) {
                dp[i][j] = -1;
            }
        }
        return numberOfWays(0, tar, n, num, dp);
    }
}

