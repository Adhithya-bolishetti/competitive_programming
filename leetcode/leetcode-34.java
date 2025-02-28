class Solution {
    public int leftMost(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(low>=nums.length || nums[low]!=target){
            return -1;
        }
        return low;
    }

    public int rightMost(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(high<0 || nums[high]!=target){
            return -1;
        }
        return high;
    }

    public int[] searchRange(int[] nums, int target) {
        int left=leftMost(nums,target);
        int right=rightMost(nums,target);
        return new int[]{left,right};
    }
}