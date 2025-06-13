import java.util.*;

public class Main
{
    public static String longestCommonString(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<m; i++) dp[i][0] = 0;
        for(int i=0; i<n; i++) dp[0][i] = 0;
        
        int maxLength = 0;
        int endIndex = 0;
        
        for(int index1=1; index1<=m; index1++) {
            for(int index2=1; index2<=n; index2++) {
                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                    
                    if(dp[index1][index2] > maxLength) {
                        maxLength = dp[index1][index2];
                        endIndex = index1;
                    }
                }
                else {
                    dp[index1][index2] = 0;
                }
            }
        }
        
        return text1.substring(endIndex - maxLength, endIndex);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		String ans = longestCommonString(text1, text2);
		System.out.println(ans);
	}
}
// Time complexity : O(n * m)
// Space complexity : O(n * m)