class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0;
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                    l=r+1;
                }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}