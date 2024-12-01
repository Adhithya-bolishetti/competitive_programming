class Solution {
    public boolean isPossible(int n,int[] quantities,int k){
        for(int i=0;i<quantities.length;i++){
           int val=quantities[i]/k;
           if(quantities[i]%k!=0){
            val++;
           }
            n-=val;
            if(n<0){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l=1;
        int r=(int)Math.pow(10,5);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(n,quantities,mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}