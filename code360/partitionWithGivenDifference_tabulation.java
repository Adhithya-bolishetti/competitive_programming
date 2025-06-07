import java.util.*;
import java.io.*;

public class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;

        if (sum - d < 0 || (sum - d) % 2 != 0) return 0;

        int s2 = (sum - d) / 2;
        int[][] dp = new int[n][s2 + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;  
        } else {
            dp[0][0] = 1; 
            if (arr[0] <= s2) dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= s2; t++) {
                int notPick = dp[i - 1][t];
                int pick = 0;
                if (t >= arr[i]) {
                    pick = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = (notPick + pick) % 1000000007;
            }
        }

        return dp[n - 1][s2];
    }
}
// Time complexity : O(n * s2)
// Space complexity : O(n * s2)