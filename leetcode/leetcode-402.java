class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // If still have k digits to remove
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n) for the stack