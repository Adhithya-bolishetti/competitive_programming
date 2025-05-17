class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int minlen = Integer.MAX_VALUE;
        int sindex = -1;
        int count = 0;
        int l = 0;
        int[] hash = new int[256];
        for(int i=0;i<t.length();i++) {
            hash[t.charAt(i)]++;
        }
        for(int r=0;r<s.length();r++) {
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;
            while(count == t.length()) {
                if((r-l+1) < minlen) {
                    minlen = r-l+1;
                    sindex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
        }
        return sindex == -1 ? "" : s.substring(sindex,sindex+minlen);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1) - since the hash array is of fixed size (256)