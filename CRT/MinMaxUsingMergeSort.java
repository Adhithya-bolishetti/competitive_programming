import java.util.*;

public class Main {
    public static void merge(int[] arr, int low, int mid, int high, int[] comparisons, int[] min, int[] max) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            comparisons[0]++;
            if (left[i] <= right[j]) {
                min[0] = Math.min(min[0], left[i]);
                max[0] = Math.max(max[0], right[j]);
                arr[k++] = left[i++];
            } else {
                min[0] = Math.min(min[0], right[j]);
                max[0] = Math.max(max[0], left[i]);
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int[] comparisons, int[] min, int[] max) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid, comparisons, min, max);
        mergeSort(arr, mid + 1, high, comparisons, min, max);
        merge(arr, low, mid, high, comparisons, min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] comparisons = new int[1]; 
        int[] min = new int[1];
        int[] max = new int[1];
        min[0] = Integer.MAX_VALUE;
        mergeSort(arr, 0, n - 1, comparisons, min, max);

        System.out.println("Total comparisons: " + comparisons[0]);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Min Value : " + min[0]);
        System.out.println("Max value : " + max[0]);
    }
}
// Time complexity : O(nlogn)
// Space complexity : O(n)