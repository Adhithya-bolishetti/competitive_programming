class Solution {
    public boolean isPossible(int[] nums,int mid,int t){
        for(int i=0;i<nums.length;i++){
            t-=(int)Math.ceil((float)nums[i]/mid);
            if(t<0){
                return false;
            }
        }
        return true;
    }
    public int findMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=findMax(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,mid,threshold)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}