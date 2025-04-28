class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()) {
            if(hash[s.charAt(r)] != -1) {
                if(hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxLen = Math.max(r-l+1,maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1) (256 characters)