class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length-1) {
            int farthest = 0;
            for(int index=l; index<=r; index++) {
                farthest = Math.max(farthest,index+nums[index]);
            }
            jumps++;
            l = r+1;
            r = farthest;
        }
        return jumps;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)