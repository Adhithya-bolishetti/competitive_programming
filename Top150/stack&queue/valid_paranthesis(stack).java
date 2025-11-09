class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1) return false;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            else {
                if(st.isEmpty()) return false;
                if((c == ')' && st.peek() == '(') 
                || (c == ']' && st.peek() == '[') 
                || (c == '}' && st.peek() == '{')) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}