import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int prev = 0;
        int prev2 = 0;
        for(int i=1; i<n; i++) {
            int fs = prev + Math.abs(arr[i]-arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) {
                ss = prev2 + Math.abs(arr[i]-arr[i-2]);
            }
            int curr = Math.min(fs,ss);
            prev2 = prev;
            prev = curr;
            
        }
        System.out.print(prev);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)