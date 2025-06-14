class Solution {
    public boolean isMatched(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            return isMatched(s, p, i - 1, j - 1);
        }

        if (p.charAt(j) == '*') {
            return isMatched(s, p, i - 1, j) || isMatched(s, p, i, j - 1);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return isMatched(s, p, n - 1, m - 1);
    }
}
// Time complexity : exponential
// Space complexity : O(n * m) stack space