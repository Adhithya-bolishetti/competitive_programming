class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        int nextIndex = 0;
        
        for(int i=0;i<s.length();i++) {
            for(int j=nextIndex;j<t.length();j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    nextIndex = j+1;
                    count++;
                    break;
                }
            }
        }

        return count == s.length() ? true : false;
    }
}
//Time Complexity: O(n*m) where n is length of s and m is length of t
//Space Complexity: O(1)