class Solution {
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }
}
//Time Complexity: O(n^2) in the worst case due to repeated string replacements
//Space Complexity: O(1) as no additional data structures are used