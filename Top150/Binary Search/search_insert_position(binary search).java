class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length;
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index;
    }
}
//Time Complexity: O(log n)
//Space Complexity: O(1)