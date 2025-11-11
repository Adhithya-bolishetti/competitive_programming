class Solution {
    public int kadaneMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircularSum = kadaneMaxSum(nums);
        int totalSum = 0;

        for(int i=0;i<nums.length;i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        int circularSum = totalSum + kadaneMaxSum(nums);

        if(circularSum == 0) return nonCircularSum;

        return Math.max(circularSum, nonCircularSum);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)