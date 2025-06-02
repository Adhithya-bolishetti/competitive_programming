import java.util.*;
import java.io.*;

public class Solution {

    // Function to count the number of subsets with sum = k
    public static int countSubsets(int[] arr, int index, int k, int[][] dp) {
        if (k == 0) return 1;
        if (index == 0) return arr[0] == k ? 1 : 0;

        if (dp[index][k] != -1) return dp[index][k];

        int notPick = countSubsets(arr, index - 1, k, dp);
        int pick = 0;
        if (k >= arr[index]) {
            pick = countSubsets(arr, index - 1, k - arr[index], dp);
        }

        return dp[index][k] = pick + notPick;
    }

    // Function to print all subsets that sum to k
    public static void printSubsets(int[] arr, int index, int k, List<Integer> current) {
        if (k == 0) {
            System.out.println(current);
            return;
        }
        if (index < 0 || k < 0) return;

        // Include current element
        current.add(arr[index]);
        printSubsets(arr, index - 1, k - arr[index], current);
        current.remove(current.size() - 1); // Backtrack

        // Exclude current element
        printSubsets(arr, index - 1, k, current);
    }

    public static void subsetSumToK(int n, int k, int[] arr) {
        // Count subsets
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int count = countSubsets(arr, n - 1, k, dp);
        System.out.println("Total subsets with sum " + k + ": " + count);

        // Print subsets
        System.out.println("Subsets with sum " + k + ":");
        printSubsets(arr, n - 1, k, new ArrayList<>());
    }

    // For testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        subsetSumToK(arr.length, k, arr);
    }
}
