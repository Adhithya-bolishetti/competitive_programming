import java.util.*; 
import java.io.*; 

public class Solution {
	static int maxChocoUtil(int i, int j1, int j2, int m, int n, int[][] grid) {
		if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
			return (int)(-1e9);

		if (i == m - 1) {
			if (j1 == j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}

		int maxi = Integer.MIN_VALUE;

		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {
				int ans;
				if (j1 == j2)
					ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, m, n, grid);
				else
					ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, m, n, grid);

				maxi = Math.max(maxi, ans);
			}
		}
		return maxi;
	}

	public static int maximumChocolates(int r, int c, int[][] grid) {
		return maxChocoUtil(0, 0, c - 1, r, c, grid); 
	}
}
// Time complexity : O(9^r)
// Space complexity : O(r)