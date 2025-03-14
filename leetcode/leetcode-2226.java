class Solution {
    public boolean isPossible(int[] candies,int mid,long k){
        int n=candies.length;
        for(int i=0;i<n;i++){
            int temp=candies[i]/mid;
            k-=temp;
            if(k<=0){
                return true;
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        int high=(int)Math.pow(10,7);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(candies,mid,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}