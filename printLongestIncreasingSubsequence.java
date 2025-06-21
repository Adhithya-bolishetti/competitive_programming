
class Solution {
    public int[] printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int max = Integer.MIN_VALUE;
        int lastIndex = 0;

        for(int i=0; i<n; i++) {
            hash[i] = i;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        int[] list = new int[max];
        list[0] = nums[lastIndex];
        int ind = 1;

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list[ind++] = nums[lastIndex];
        }

        for(int i=max-1; i>=0; i--) {
            System.out.print(list[i]+" ");
        }
        return list;
    }
}
