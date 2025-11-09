class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;

        for(int i=0;i<n;i++) {
            int minheight = heights[i];
            for(int j=i;j<n;j++) {
                minheight = Math.min(minheight, heights[j]);
                int area = minheight * (j - i + 1);
                res = Math.max(res, area);
            }
        }

        return res;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)