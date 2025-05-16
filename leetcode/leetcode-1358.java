class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            int[] hash = new int[3];
            for(int j=i;j<s.length();j++) {
                hash[s.charAt(j) - 'a']++;
                if(hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1) because the size of the hash array is constant (3)