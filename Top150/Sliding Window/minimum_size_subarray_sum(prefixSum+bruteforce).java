class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for(int i=0;i<n;i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if(sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(n)
//Appoach : prefix sum array and two nested loops to find minimum length subarray with sum >= target