// User function Template for Java

class Solution {
    int countWays(int n, int k) {
        // code here.
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }


        int same = countWays(n - 2, k) * (k - 1);
        int diff = countWays(n - 1, k) * (k - 1);

        return same + diff;
    }
}
