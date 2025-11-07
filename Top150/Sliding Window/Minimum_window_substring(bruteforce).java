class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int sindex = -1;
        int minlen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[256];
            int count = 0;

            for (int x = 0; x < t.length(); x++) {
                hash[t.charAt(x)]++;
            }

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (hash[ch] > 0) {
                    count++;
                }
                hash[ch]--;

                if (count == t.length()) {
                    if (j - i + 1 < minlen) {
                        minlen = j - i + 1;
                        sindex = i;
                    }
                    break; 
                }
            }
        }

        return sindex == -1 ? "" : s.substring(sindex, sindex + minlen);
    }
}
//Time Complexity: O(N^2)
//Space Complexity: O(1)