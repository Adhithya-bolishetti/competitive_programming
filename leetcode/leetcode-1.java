class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        int l=0;
        for(int r=l;r<nums.length;r++){
            if((nums[l]+nums[r])==target){
                ans[0]=l;
                ans[1]=r;
            }
            else if(r==nums.length-1){
                l++;
                r=l;
            }
        }
        return ans;
    }
}