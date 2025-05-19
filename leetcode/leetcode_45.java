public class Solution {
    public int jump(int[] nums) {
        return recursiveJump(nums, 0, 0);
    }

    private int recursiveJump(int[] nums, int index, int jumps) {
        // Base case: Reached or passed the last index
        if (index >= nums.length - 1) {
            return jumps;
        }

        int minJumps = Integer.MAX_VALUE;

        // Try every possible jump from 1 to maxJump
        for (int i = 1; i <= nums[index]; i++) {
            minJumps = Math.min(minJumps, recursiveJump(nums,index+i,jumps+1));
        }

        return minJumps;
    }
}
//Time Complexity : O(n^n)
//Space Complexity : O(n)