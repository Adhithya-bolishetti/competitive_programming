class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max = -1;
        int smax = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                smax = max;
                max = arr[i];
            }
            else if(arr[i] < max && arr[i] > smax) {
                smax = arr[i];
            }
        }
        
        return smax;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)