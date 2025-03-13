class Solution {
    public int isPossible(int[] weights,int n,int mid){
        int sum=0;
        int Ndays=1;
        for(int i=0;i<n;i++){
            if(sum+weights[i]>mid){
                Ndays+=1;
                sum=weights[i];
            }
            else{
                sum+=weights[i];
            }
        }
        return Ndays;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,n,mid)<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}