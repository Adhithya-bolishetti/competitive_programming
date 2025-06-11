class Solution {
    public int countSubsequence(String text1, String text2, int index1, int index2) {
        if(index1 < 0 || index2 < 0) return 0;
        if(text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + countSubsequence(text1, text2, index1 - 1, index2 - 1);
        }
        return Math.max(countSubsequence(text1, text2, index1 - 1, index2),
        countSubsequence(text1, text2, index1, index2 - 1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return countSubsequence(text1, text2, text1.length() - 1, text2.length() - 1);
    }
}
// Time complexity : O(2 ^ n)
// Space complexity : O(n) stack space