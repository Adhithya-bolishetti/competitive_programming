class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] >= target) {
                return i;
            } 
        }

        return nums.length;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)