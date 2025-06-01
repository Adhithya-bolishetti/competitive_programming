import java.util.*; 
import java.io.*; 

public class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];

        // Base case for last row
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2)
                    dp[r - 1][j1][j2] = grid[r - 1][j1];
                else
                    dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
            }
        }

        // Bottom-up DP
        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int maxi = (int)-1e9;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int nj1 = j1 + di;
                            int nj2 = j2 + dj;

                            if (nj1 >= 0 && nj1 < c && nj2 >= 0 && nj2 < c) {
                                int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                value += dp[i + 1][nj1][nj2];
                                maxi = Math.max(maxi, value);
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c - 1]; 
    }
}
// Time complexity : O(r*c^2)
// Space complexity : O(r*c^2)