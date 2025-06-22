class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int lastIndex = 0;

        for(int i=0; i<n; i++) {
            hash[i] = i;
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }

        return list;
    }
}