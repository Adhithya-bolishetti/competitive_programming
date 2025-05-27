import java.util.*;
public class Main
{
    public static int findMerit(int[][] arr, int day, int last, int[][] dp) {
        if(day == 0) {
            int max = 0;
            for(int i=0; i<arr[0].length; i++) {
                if(i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return max;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for(int i=0; i<arr[0].length; i++) {
            if(i != last) {
                int points = arr[day][i] + findMerit(arr, day-1, i, dp);
                max = Math.max(max, points);
            }
            dp[day][last] = max;
        }
        return max;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = {{1,2,3},
		               {2,3,4},
		               {3,4,5},
		               {4,5,6}};
		int[][] dp = new int[arr.length][arr[0].length+1];
		for(int[] row : dp) {
		    Arrays.fill(row,-1);
		}
		int ans = findMerit(arr, arr.length-1, arr[0].length, dp);
		System.out.print(ans);
	}
}
// Time complexity : O(n)
// Space complexity : O(n)