import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {

        int n = num.length;
        int dp[][] = new int[n][tar + 1];
        
        dp[0][0] = (num[0] == 0) ? 2 : 1;
        if (num[0] != 0 && num[0] <= tar) dp[0][num[0]] = 1;

        for(int i=1; i<n; i++) {
            for(int t=0; t<=tar; t++) {
                int notPick = dp[i-1][t];
                int pick = 0;
                if(num[i] <= t) {
                    pick = dp[i-1][t-num[i]];
                }
                dp[i][t] = (pick + notPick) % 1000000007;
            }
        }

        return dp[n-1][tar];
    }
}
// Time complexity : O(n*tar)
// Space complexity : O(n*tar)