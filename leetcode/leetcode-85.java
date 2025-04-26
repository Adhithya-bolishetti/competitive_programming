import java.util.Stack;

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

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {  // Fixed increment
                if (matrix[j][i] == '0') sum = 0;
                else sum += 1;  // Count consecutive '1's
                prefixSum[j][i] = sum;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i])); 
        }
        return maxArea;
    }
}
