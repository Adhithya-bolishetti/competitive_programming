import java.util.*;

public class Main
{
    public static int climbingStairs(int n) {
        if(n == 0) return 1;
        if(n == 1 || n == 2) return n;
        return climbingStairs(n-1) + climbingStairs(n-2);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = climbingStairs(n);
		System.out.print(ans);
	}
}
// Time complexity : O(2^n)
// Space complexity : O(n) stack space