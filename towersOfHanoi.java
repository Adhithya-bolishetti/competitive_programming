import java.util.*;

public class Main {

    // Simulates moving the topmost disk from 'from' array to 'to' array
    public static void swap(int[] from, int[] to) {
        int i = from.length - 1;

        // Find the topmost disk in the source peg
        while (i >= 0 && from[i] == 0) {
            i--;
        }

        if (i < 0) return; // No disk to move

        int disk = from[i];
        from[i] = 0; // Remove disk from source

        // Find the first empty spot in the destination peg
        int j = 0;
        while (j < to.length && to[j] != 0) {
            j++;
        }

        if (j < to.length) {
            to[j] = disk; // Place disk
        }
    }

    public static void towersOfHanaii(int[] source, int[] dest, int[] temp, int n) {
        if (n <= 0) return;

        towersOfHanaii(source, temp, dest, n - 1);
        swap(source, dest);
        towersOfHanaii(temp, dest, source, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n:");
        int n = sc.nextInt();

        System.out.println("Enter array elements (top to bottom):");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = new int[n];
        int[] dest = new int[n];

        towersOfHanaii(arr, dest, temp, n);

        System.out.println("Result tower is (bottom to top):");
        for (int i = 0; i < dest.length; i++) {
            if (dest[i] != 0)
                System.out.print(dest[i] + " ");
        }
    }
}
