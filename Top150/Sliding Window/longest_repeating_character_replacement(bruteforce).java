class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        
        for(int i=0;i<n;i++) {
            Map<Character, Integer> map = new HashMap<>();
            int maxf = 0;
            for(int j=i;j<n;j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) +1);
                maxf = Math.max(maxf, map.get(s.charAt(j)));
                if((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}
//Time Complexity: O(N^2)
//Space Complexity: O(1)