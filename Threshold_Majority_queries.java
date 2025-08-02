class Solution {
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for(int i=0; i<queries.length;i++) {
            TreeMap<Integer,Integer> hm = new TreeMap<>();
            for(int j=queries[i][0]; j<=queries[i][1];j++) {
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            }
            int value = 0;
            for(int key : hm.keySet()) {
                if(value >= hm.get(key)) {
                    continue;
                }
                if(hm.get(key) >= queries[i][2]) {
                    value = hm.get(key);
                    ans[i] = key;
                }
            }
        }
        return ans;
    }
}