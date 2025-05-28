class Solution {
    public int countPaths(int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        int left = countPaths(m-1, n);
        int up = countPaths(m, n-1); 
        return left + up;
    }
    public int uniquePaths(int m, int n) {
        return countPaths(m-1,n-1);
    }
}
// Time complexity : O(2^(m*n))
// Space complexity : O(n)