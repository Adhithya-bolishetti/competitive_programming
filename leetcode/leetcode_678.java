class Solution {
    public boolean check(String s, int index,int count) {
        if(count < 0) return false;
        if(index == s.length()) return count == 0;
        if(s.charAt(index) == '(') {
            check(s,index+1,count+1);
        }
        if(s.charAt(index) == ')') {
            check(s,index+1,count-1);
        }
        return check(s,index+1,count+1) || check(s,index+1,count-1) || check(s,index+1,count);
    }
    public boolean checkValidString(String s) {
        if(s.length() == 1 || s.length()-1 == '(') return false;
        return check(s,0,0);
    }
}
// Time Complexity: O(3^n)
// Space Complexity: O(n)