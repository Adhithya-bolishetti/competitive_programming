class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int low=0;
        int high=arr.size()-1;
        int count=0;
        int min=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(low)<=arr.get(mid)){
                if(min>arr.get(low)){
                    min=arr.get(low);
                    count=low;
                }
                low=mid+1;
            }
            else{
                if(min>arr.get(mid)){
                    min=arr.get(mid);
                    count=mid;
                }
                high=mid-1;
            }
        }
        return count;
    }
}