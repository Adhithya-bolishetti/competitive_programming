import java.util.*;

public class Main {
    public static int minEnergy(int[] arr, int index) {
        if (index == 0) return 0;

        int left = minEnergy(arr, index - 1) + Math.abs(arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;

        if (index > 1) {
            right = minEnergy(arr, index - 2) + Math.abs(arr[index] - arr[index - 2]);
        }

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = minEnergy(arr, n - 1);
        System.out.print(ans);
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)