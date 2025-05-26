class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++) {
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
       return prev1;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)