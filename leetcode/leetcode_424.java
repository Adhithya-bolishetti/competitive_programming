class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen = 0;
        for(int i=0;i<s.length();i++) {
            int[] hash = new int[26];
            int maxfreq = 0;
            for(int j=i;j<s.length();j++) {
                hash[s.charAt(j)-'A']++;
                maxfreq = Math.max(maxfreq,hash[s.charAt(j)-'A']);
                int changes = (j-i+1) - maxfreq;
                if(changes <= k) {
                    maxlen = Math.max(maxlen,j-i+1);
                }
                else {
                    break;
                }
            }
        }
        return maxlen;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1) since we are using a fixed size array of 26