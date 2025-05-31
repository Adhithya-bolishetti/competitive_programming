import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] lengths = new int[n];
		for(int i=0; i<n; i++) {
		    lengths[i] = sc.nextInt();
		}
		Arrays.sort(lengths);
		int sum = 0;
		int prevSum = 0;
		for(int i=0; i<n; i++) {
		    prevSum += lengths[i];
		    sum += prevSum;
		}
		System.out.print(sum);
	}
}
// Time complexity : O(nlogn)
// Space complexity : O(1)