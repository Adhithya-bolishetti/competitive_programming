class Solution {
    public int countSubsequences(String s, String t, int i, int j) {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(s.charAt(i) == t.charAt(j)) {
            return countSubsequences(s, t, i-1, j-1) + countSubsequences(s, t, i-1, j);
        }
        return countSubsequences(s, t, i-1, j);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return countSubsequences(s, t, n-1, m-1);
    }
}
// Time complexity : O(2^n * 2^m) exponential
// Space complexity : O(n) stack space