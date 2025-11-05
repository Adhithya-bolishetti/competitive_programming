class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int length = 0;
        Set<Character> seen = new HashSet<>();
        
        int l = 0;
        for(int r=0;r<n;r++) {
            while(seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            length = Math.max(length, r - l + 1);
        }

        return length;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(min(m, n)) where m is the size of the charset