class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        Set<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()) {
            charSet.add(c);
        }

        for(char c : charSet) {
            int count = 0;
            int l = 0;
            for(int r=0;r<n;r++) {
                if(s.charAt(r) == c) {
                    count++;
                }
                while((r - l + 1) - count > k) {
                    if(s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l +1);
            }
        }

        return res;
    }
}
// Time Complexity: O(26 * n) = O(n)
// Space Complexity: O(1)