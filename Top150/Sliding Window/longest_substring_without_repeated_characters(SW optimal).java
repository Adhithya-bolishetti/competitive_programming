class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int n = s.length();
        int length = 0;
        int l = 0;

        for(int r=0;r<n;r++) {
            if(seen.containsKey(s.charAt(r))) {
                l = Math.max(l, seen.get(s.charAt(r)) + 1);
            }
            seen.put(s.charAt(r), r);
            length = Math.max(length, r - l + 1);
        }

        return length;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(min(m, n)) where m is the size of the charset and n is the size of the string