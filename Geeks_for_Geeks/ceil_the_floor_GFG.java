class Solution {
    public int getFloor(int x,int[] arr,int n){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                high=mid-1;
            }
            else{
                ans=arr[mid];
                low=mid+1;
            }
        }
        return ans;
    }
    public int getCeil(int x,int[] arr,int n){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<x){
                low=mid+1;
            }
            else{
                ans=arr[mid];
                high=mid-1;
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int floor=getFloor(x,arr,n);
        int ceil=getCeil(x,arr,n);
        return new int[]{floor,ceil};
    }
}
