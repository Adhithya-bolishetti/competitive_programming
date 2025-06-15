class Solution {
    public int longestIncreasingSubsequence(int[] nums,int  ind, int prev_ind) {
        if(ind >= nums.length) return 0;
        int notPick = longestIncreasingSubsequence(nums, ind + 1, prev_ind);
        int pick = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            pick = 1 + longestIncreasingSubsequence(nums, ind + 1, ind);
        }
        return Math.max(notPick, pick);
    }
    public int lengthOfLIS(int[] nums) {
        return longestIncreasingSubsequence(nums, 0, -1);
    }
}
// Time complexity : O(2 ^ n)
// Space complexity : O(n) stack space