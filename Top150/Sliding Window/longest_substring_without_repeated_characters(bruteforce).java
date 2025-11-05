class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int length = 0;

        for(int i=0;i<n;i++) {
            Set<Character> seen = new HashSet<>();
            for(int j=i;j<n;j++) {
                if(seen.contains(s.charAt(j))) break;
                seen.add(s.charAt(j));
            }
            length = Math.max(length, seen.size());
        }

        return length;
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(min(m,n)) where m is the size of charset and n is the length of string s