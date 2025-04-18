import java.util.*;

public class SubmatricwithMaxSum {
    // Function to find the submatrix with maximum sum of size k x k
    public static void main(String[] args) {
        int[][] arr = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        int k = 2;

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] prefixSum = new int[rows][cols];

        // Correct prefix sum logic
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = arr[i][j];
                if (i > 0) prefixSum[i][j] += prefixSum[i - 1][j];
                if (j > 0) prefixSum[i][j] += prefixSum[i][j - 1];
                if (i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int rind = 0, cind = 0;

        // Loop through all possible top-left corners of k x k submatrices
        for (int i = 0; i <= rows - k; i++) {
            for (int j = 0; j <= cols - k; j++) {
                int r2 = i + k - 1;
                int c2 = j + k - 1;

                int total = prefixSum[r2][c2];
                if (i > 0) total -= prefixSum[i - 1][c2];
                if (j > 0) total -= prefixSum[r2][j - 1];
                if (i > 0 && j > 0) total += prefixSum[i - 1][j - 1];

                if (total > maxSum) {
                    maxSum = total;
                    rind = i;
                    cind = j;
                }
            }
        }

        // Print the submatrix with maximum sum
        for (int i = rind; i < rind + k; i++) {
            for (int j = cind; j < cind + k; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
