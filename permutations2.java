import java.util.*;

public class permutations2
{
    public static void swap(char[] arr, int k, int i) {
        char temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
        return;
    }
    public static boolean isValid(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Check for 'A' next to 'B' or 'B' next to 'A'
            if ((arr[i] == 'A' && arr[i + 1] == 'B') || (arr[i] == 'B' && arr[i + 1] == 'A')) {
                return false;
            }
            // Check for 'C' next to 'E' or 'E' next to 'C'
            if ((arr[i] == 'C' && arr[i + 1] == 'E') || (arr[i] == 'E' && arr[i + 1] == 'C')) {
                return false;
            }
        }
        return true;
    }

    public static void permutations(char[] arr, int k, int n) {
        if (k == n - 1) {
            if (isValid(arr)) {
                for (int i=0;i<n;i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = k; i < n; i++) {
            swap(arr, k, i);
            permutations(arr, k + 1, n);
            swap(arr, k, i); // backtrack
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String s = sc.next();
		char[] arr = s.toCharArray();
		int n = arr.length;
		int k = 0;
		System.out.println("Permutations of given string is :");
		permutations(arr,k,n);
	}
}