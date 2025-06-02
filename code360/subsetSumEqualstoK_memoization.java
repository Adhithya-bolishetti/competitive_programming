import java.util.*;
import java.io.*;

public class Solution {

    public static int subsetSum(int[] arr, int index, int k, int[][] dp) {
        if (k == 0) return 1;
        if (index == 0) return arr[0] == k ? 1 : 0;

        if (dp[index][k] != -1) return dp[index][k];

        int notPick = subsetSum(arr, index - 1, k, dp);
        int pick = 0;
        if (k >= arr[index]) {
            pick = subsetSum(arr, index - 1, k - arr[index], dp);
        }

        dp[index][k] = (notPick == 1 || pick == 1) ? 1 : 0;
        return dp[index][k];
    }

    public static boolean subsetSumToK(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1]; 

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return subsetSum(arr, n - 1, k, dp) == 1;
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n*k) + O(n)(stack)