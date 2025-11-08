class Solution {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++) {
            if(nums[r] != val) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
                res++;
            }
        }
        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)