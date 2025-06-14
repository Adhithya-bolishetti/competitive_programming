class Solution {
    public int countOperations(String word1, String word2, int i, int j) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(word1.charAt(i) == word2.charAt(j)) {
            return countOperations(word1, word2, i-1, j-1);
        } 
        int insert = 1 + countOperations(word1, word2, i, j-1);
        int delete = 1 + countOperations(word1, word2, i-1, j);
        int replace = 1 + countOperations(word1, word2, i-1, j-1);
        return Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return countOperations(word1, word2, n-1, m-1);
    }
}
// Time complexity : exponential
// Space complexity : O(n * m) stack space