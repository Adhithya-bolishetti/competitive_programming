class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int length = left + right + 1;

                map.put(num, length);
                map.put(num - left, length);
                map.put(num + right, length);
                
                res = Math.max(res, length);
            }
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)