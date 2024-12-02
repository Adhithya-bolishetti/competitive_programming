class Solution {
    public boolean isPossible(int[] nums,int max,int k){
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int temp=val/k;
            if(val%k!=0){
                temp++;
            }
            temp--;
            max-=temp;
            if(max<0){
                return false;
            }
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1;
        int r=(int)Math.pow(10,9);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(nums,maxOperations,mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}