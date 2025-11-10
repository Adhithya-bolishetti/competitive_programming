class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            res = Math.min(res, nums[i]);
        }

        return res;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)