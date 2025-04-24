class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        st.clear();
        int[] pse = new int[n];
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            pse[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        int max = 0;
        for(int i=0;i<n;i++) {
            int area = heights[i]*(nse[i]-pse[i]-1);
            max = Math.max(max,area);
        }
        return max;
    }
}