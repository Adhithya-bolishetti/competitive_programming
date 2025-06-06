import java.util.*;
import java.io.*;

public class Solution {
    public static int countWays(int[] num, int index, int tar) {
         if (index == 0) {
            if (tar == 0 && num[0] == 0) return 2;
            return (tar == 0 || tar == num[0]) ? 1 : 0;
        }

        int notPick = countWays(num, index - 1, tar);

        int pick = 0;
        if (num[index] <= tar) {
            pick = countWays(num, index - 1, tar - num[index]);
        }

        return pick + notPick;
    }

    public static int findWays(int[] num, int tar) {
        int[][] dp = new int[num.length][tar+1];
        return countWays(num, num.length - 1, tar);
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n) stack space