class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length==0)
       return 0;
        int ans=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]!=nums[ans-1]){
            nums[ans]=nums[i];
            ans++;
           }
        }
        return ans;
    }
}