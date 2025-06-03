import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prev1 = 1;
		int prev2 = 1;
		for(int i=2; i<=n; i++) {
		    int curr = prev1 + prev2;
		    prev2 = prev1;
		    prev1 = curr;
		}
		System.out.print(prev1);
	}
}
// Time complexity : O(n)
// Space complexity : O(1)