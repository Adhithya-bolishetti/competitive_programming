import java.util.*;

public class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][] front = new int[c][c];
        int[][] cur = new int[c][c];

        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[r - 1][j1];
                else
                    front[j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int maxi = (int) -1e9;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < c && nj2 >= 0 && nj2 < c) {
                                int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                val += front[nj1][nj2];
                                maxi = Math.max(maxi, val);
                            }
                        }
                    }

                    cur[j1][j2] = maxi;
                }
            }

            for (int a = 0; a < c; a++) {
                for (int b = 0; b < c; b++) {
                    front[a][b] = cur[a][b];
                }
            }
        }

        return front[0][c - 1];
    }
}
// Time complexity : O(r*c^2)
// Space complexity : O(c^2)