class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int val : nums) {
            if (val != 0) product *= val;
            else zeroCount++;
        }

        if(zeroCount > 1) return new int[nums.length];

        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(zeroCount > 0) {
                res[i] = (nums[i] == 0) ? product : 0;
            }
            else {
                res[i] = product/nums[i];
            }
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)