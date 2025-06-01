import java.util.*;

class Solution {
    public void subsets(int[] nums, int index, int[] subset, int subsetSize, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < subsetSize; i++) {
                temp.add(subset[i]);
            }
            res.add(temp);
            return;
        }

        subsets(nums, index + 1, subset, subsetSize, res);
        subset[subsetSize] = nums[index];
        subsets(nums, index + 1, subset, subsetSize + 1, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int[] subset = new int[nums.length];
        subsets(nums, 0, subset, 0, res);
        
        Set<List<Integer>> unique = new HashSet<>(res);
        return new ArrayList<>(unique);
    }
}
// Time complexity : O(2^n*n)
// Space complexity : O(2^n*n)