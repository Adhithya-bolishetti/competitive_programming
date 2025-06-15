class Solution {
    public void longestIncreasingSubsequence(int[] nums, int i, ArrayList<Integer> list, int n, int[] max) {
        if(i == n) {
            boolean flag = true;
            for(int j=1; j<list.size(); j++) {
                if(list.get(j) <= list.get(j-1)) {
                    flag = false;
                    break;
                }
            }
            if(flag) max[0] = Math.max(max[0], list.size());
            return;
        }

        longestIncreasingSubsequence(nums, i+1, list, n, max);
        list.add(nums[i]);
        longestIncreasingSubsequence(nums, i+1, list, n, max);
        list.remove(list.size() - 1);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] max = new int[1];
        longestIncreasingSubsequence(nums, 0, list, n, max);
        return max[0];
    }
}
// Time complexity : O(2 ^ n)
// Space complexity : O(n) ArrayList + O(n) stack space