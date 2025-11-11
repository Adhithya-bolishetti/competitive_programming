class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int sum = 0;
                for(int k=i;k<=j;k++) {
                     sum += nums[k];   
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
// Time Complexity: O(N^3)
// Space Complexity: O(1)