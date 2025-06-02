import java.util.*;
import java.io.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[ind - 1][target];
                boolean pick = false;
                if (target >= arr[ind]) {
                    pick = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = pick || notPick;
            }
        }

        return dp[n - 1][k];
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n*k)