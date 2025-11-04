class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newS = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                newS.append(Character.toLowerCase(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=newS.length()-1;i>=0;i--) {
            sb.append(newS.charAt(i));
        }

        return sb.toString().equals(newS.toString());
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)