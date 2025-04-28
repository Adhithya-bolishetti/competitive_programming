class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0;
        int zeroes = 0;
        for(int r=0;r<nums.length;r++) {
            if(nums[r] == 0) zeroes++;
            if(zeroes > k) {
                if(nums[l] == 0) zeroes--;
                l++;
            }
            if(zeroes <= k) {
                maxLen = Math.max(maxLen,r-l+1);
            }
        }
        return maxLen;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)