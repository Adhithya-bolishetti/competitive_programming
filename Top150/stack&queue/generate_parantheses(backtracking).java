class Solution {
    public void dfs(int open, int close, String s, List<String> res, int n) {
        if(open == close && s.length() == n * 2) {
            res.add(s);
            return;
        }

        if(open < n) {
            dfs(open + 1, close, s + '(', res, n);
        }

        if(close < open) {
            dfs(open, close +1, s + ')', res, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, "", res, n);
        return res;
    }
}
// Time Complexity: O(2^n)
// Space Complexity: O(n)