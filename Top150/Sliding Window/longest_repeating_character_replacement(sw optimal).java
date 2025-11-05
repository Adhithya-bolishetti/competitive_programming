class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        Map<Character, Integer> charSet = new HashMap<>();
        int l = 0;
        int maxf = 0;

        for(int r=0;r<n;r++) {
            charSet.put(s.charAt(r), charSet.getOrDefault(s.charAt(r), 0) +1);
            maxf = Math.max(maxf, charSet.get(s.charAt(r)));
            while((r - l + 1) - maxf > k) {
                charSet.put(s.charAt(l), charSet.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)