int leftMost(int[] arr,int target){
        int low=0;
        int high=mid-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(low>=arr.length || arr[low]!=target){
                return 0;
        }
        return low;
    }