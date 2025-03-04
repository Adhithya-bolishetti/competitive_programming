class Solution {
    public int findMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public boolean isPossible(int[] arr,int n,int h){
        for(int i=0;i<arr.length;i++){
            int temp=arr[i]/n;
            if(arr[i]%n!=0){
                temp++;
            }
            h-=temp;
            if(h<0){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(piles,mid,h)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}