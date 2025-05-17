class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            Map<Integer,Integer> hm = new HashMap<>();
            for(int j=i;j<nums.length;j++) {
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                if(hm.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(n)