class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;

        Arrays.sort(nums);
        int res = 0;
        int streak = 0;
        int curr = nums[0];
        int i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }

        return res;
    }
}
//Time Complexity: O(n log n) due to sorting
//Space Complexity: O(1)