import java.util.*;

public class Main {
    // Rotate a 2D matrix clockwise
    public static void rotate2D(int[][] mat, int n) {
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
            }
        }
    }

    public static int[][][] rotate(int[][][] arr, int n, int r) {
        // Rotate each 2D layer
        int ro = 0;
        while(ro < r) {
            for (int i = 0; i < arr.length; i++) {
                rotate2D(arr[i], n);
            }
            ro++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int[][][] arr = new int[n][n][n];
    
        System.out.println("Enter the elements of the 3D array (" + (n * n * n) + " elements):");
        for (int i = 0; i < n; i++) {
            System.out.println("Layer " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }
        System.out.println("Enter degrees to rotate (90/180/270/360) : ");
        int r = sc.nextInt();
        r = r/90;
        if(r == 4) r = 0;

        int[][][] ans = rotate(arr, n, r);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Layer " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
