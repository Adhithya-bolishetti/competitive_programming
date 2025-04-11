import java.util.*;
public class two_distinct_elements
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		int xor = 0;
		for(int i=0;i<n;i++) {
		    xor ^= arr[i];
		}
		int rightMost = xor & -xor;
		int b1 = 0;
		int b2 = 0;
		for(int i=0;i<n;i++) {
		    if((arr[i] & rightMost) != 0) {
		        b1 ^= arr[i];
		    }
		    else {
		        b2 ^= arr[i];
		    }
		}
		System.out.print("The two distinct elements : "+b1+" "+b2);
	}
}