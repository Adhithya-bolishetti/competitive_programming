class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];

        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ele = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                res = Math.max(res, ele * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ele = heights[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            res = Math.max(res, ele * (nse - pse - 1));
        }

        return res;
    }
}
//Time Complexity: O(N)
//Space Complexity: O(N)