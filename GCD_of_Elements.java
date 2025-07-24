import java.util.*;

public class Main
{
    public static int gcd(int a, int b) {
        while(a != 0 && b != 0) {
            if(a > b) {
                a %= b;
            }
            else {
                b %= a;
            }
        }
        if(a > b) return a;
        return b;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
		    arr[i] = sc.nextInt();
		}
		
		int result = arr[0];
		for(int i=1; i<n; i++) {
		    result = gcd(result, arr[i]);
		}
		
		System.out.print(result);
	}
}
// Time complexity : O(n * logm)
// Space complexity : O(1)