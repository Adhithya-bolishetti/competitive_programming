

class Main {
  static int maxChocoUtil(int i, int j1, int j2, int m, int n, int[][] grid) {
    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
      return (int) (Math.pow(-10, 9));

    if (i == m - 1) {
      if (j1 == j2)
        return grid[i][j1];
      else
        return grid[i][j1] + grid[i][j2];
    }


    int maxi = Integer.MIN_VALUE;
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        int ans;
        if (j1 == j2)
          ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid);
        else
          ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid);
        maxi = Math.max(maxi, ans);
      }
    }
    return maxi;
  }


  public static void main(String args[]) {
    int matrix[][] = {{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};
    int m = matrix.length;
    int n = matrix[0].length;

    System.out.println(maxChocoUtil(0, 0, n-1, m, n, matrix));
  }
}
// Time complexity : O(9^m)
// Space complexity : O(m)