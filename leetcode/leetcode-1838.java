

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxlen = 1;
        long kk = k;
        int j = 0;

        for (int i = 1; i < nums.length; ++i) {
            kk -= (long)(nums[i] - nums[i - 1]) * (i - j);
            while (kk < 0) {
                kk += nums[i] - nums[j];
                j++;
            }

            maxlen = Math.max(maxlen, i - j + 1);
        }

        return maxlen;
    }
}