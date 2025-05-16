class Solution {
    public int subarray(int[] nums,int k) {
        if(k < 0) return 0;
        int count = 0;
        int temp = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++) {
            if(nums[r] % 2 == 1) {
                temp++;
            }
            while(temp > k) {
                if(nums[l] % 2 == 1) temp--;
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return subarray(nums,k) - subarray(nums,k-1);
    }
}
//Time complexity: O(n)
//Space complexity: O(1)