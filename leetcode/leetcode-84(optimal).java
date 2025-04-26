class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();
                max = Math.max(max,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = (st.isEmpty()) ? -1 : st.peek();
            max = Math.max(max,heights[element]*(nse-pse-1));
        }
        return max;
    }
}