import java.util.*;

public class Main
{
    public static int houseRob(int[] arr, int index) {
        if(index == 0) return arr[0];
        if(index < 0) return 0;
        int pick = arr[index] + houseRob(arr, index-2);
        int notPick = houseRob(arr, index -1);
        return Math.max(pick, notPick);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
		    arr[i] = sc.nextInt();
		}
		int ans = houseRob(arr, n-1);
		System.out.print(ans);
	}
}
// Time complexity : O(2^n)
// Space complexity : O(n) stack space