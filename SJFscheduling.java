import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int waitingTime = 0;
		int total = 0;
		for(int i=0;i<n;i++) {
		    waitingTime += total;
		    total += arr[i];
		}
		System.out.print(waitingTime/n);
	}
}
//Time complexity : O(n + nlogn)
//Space complexity : O(1)