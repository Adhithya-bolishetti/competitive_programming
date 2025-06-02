import java.util.*;
import java.io.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        if (arr[0] <= k) {
            dp[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[target];
                boolean pick = false;
                if (target >= arr[ind]) {
                    pick = dp[target - arr[ind]];
                }
                temp[target] = pick || notPick;
            }
            dp = temp;
        }

        return dp[k];
    }
}
// Time complexity : O(n*k)
// Space complexity : O(k)