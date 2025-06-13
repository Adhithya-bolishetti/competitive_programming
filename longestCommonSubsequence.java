import java.util.*;

public class Main
{
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<m; i++) dp[i][0] = 0;
        for(int i=0; i<n; i++) dp[0][i] = 0;

        for(int index1=1; index1<=m; index1++) {
            for(int index2=1; index2<=n; index2++) {
                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int k1 = m;
        int k2 = n;
        while(k1 > 0 && k2 > 0) {
            if(text1.charAt(k1-1) == text2.charAt(k2-1)) {
                sb.append(text1.charAt(k1-1));
                k1--;
                k2--;
            }
            else {
                if(dp[k1-1][k2] > dp[k1][k2-1]) k1--;
                else k2--;
            }
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		String ans = longestCommonSubsequence(text1, text2);
		System.out.println(ans);
	}
}