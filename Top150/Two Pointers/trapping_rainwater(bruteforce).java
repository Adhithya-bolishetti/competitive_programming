class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i=0;i<n;i++) {
            int j = i;
            int leftmax = 0;
            int rightmax = 0;
            while(j >= 0) {
                leftmax = Math.max(leftmax, height[j]);
                j--;
            }
            j = i;
            while(j < n) {
                rightmax = Math.max(rightmax, height[j]);
                j++;
            }
            res += Math.min(leftmax, rightmax) - height[i];
        }

        return res;
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1)