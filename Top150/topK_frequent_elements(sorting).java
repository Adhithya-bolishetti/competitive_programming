class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) +1);
        }

        List<int[]> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        list.sort((a,b) -> b[1] - a[1]);

        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}
// Time Complexity: O(N log N) due to sorting
// Space Complexity: O(N) for the hashmap and list