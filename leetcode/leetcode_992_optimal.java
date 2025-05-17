class Solution {
    public int subarray(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++) {
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.size() > k) {
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l]) == 0) hm.remove(nums[l]);
                l++;
            }
            count += (r-l+1);
            
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarray(nums,k) - subarray(nums,k-1);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)