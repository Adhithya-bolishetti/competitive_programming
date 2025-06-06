import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {

        int n = num.length;
        int dp[] = new int[tar + 1];
        
        dp[0] = (num[0] == 0) ? 2 : 1;
        if (num[0] != 0 && num[0] <= tar) dp[num[0]] = 1;

        for(int i=1; i<n; i++) {
            int[] temp = new int[tar + 1];
            for(int t=0; t<=tar; t++) {
                int notPick = dp[t];
                int pick = 0;
                if(num[i] <= t) {
                    pick = dp[t-num[i]];
                }
                temp[t] = (pick + notPick) % 1000000007;
            }
            dp = temp;
        }

        return dp[tar];
    }
}
// Time complexity : O(n*tar)
// Space complexity : O(tar)