class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List[] freq = new List[nums.length + 1];
        for(int i=0;i<freq.length;i++) {
            freq[i] = new ArrayList<>();
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int val : nums) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : (List<Integer>) freq[i]) {
                res[index++] = n;
            }
        }
        return res;
    }
}
//Time Complexity: O(N)
//Space Complexity: O(N)