class Solution {
    public int houseRob(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(houseRob(nums, 1, nums.length - 1), houseRob(nums, 0, nums.length - 2));
    }
}
// Time complexity : O(n)
// Space complexity : O(1)