class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if((nums[i] > nums[j] && dp[j]+1 == dp[i])) {
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int nos = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == max) nos += count[i];
        }

        return nos;
    }
}
//Time complexity: O(n^2)
//Space complexity: O(n)