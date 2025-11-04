class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;

        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] < leftmax) {
                    res += leftmax - height[l];
                } else {
                    leftmax = height[l];
                }
                l++;
            } else {
                if(height[r] < rightmax) {
                    res += rightmax - height[r];
                } else {
                    rightmax = height[r];
                }
                r--;
            }
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)