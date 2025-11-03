class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) set.add(val);

        int res = 0;
        for(int val : nums) {
            int streak = 0;
            int curr = val;
            while(set.contains(curr)) {
                streak++;
                curr++;
            }
            res = Math.max(streak, res);
        }   

        return res;
    }
}
// Time Complexity: O(N)
// Space Complexity: O(N)