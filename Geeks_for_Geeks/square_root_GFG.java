class Solution {
    int floorSqrt(int n) {
        int low=1;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=mid*mid;
            if(val<=(long)n){
                low=(int)mid+1;
            }
            else{
                high=(int)mid-1;
            }
        }
        return high;
        // Other method using built-in function
        // return (int)Math.sqrt(n);
    }
}
