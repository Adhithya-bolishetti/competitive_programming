class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
       int maxSum=Integer.MIN_VALUE;
       int sum=0;
       int l=0;
       for(int r=l+1;r<arr.length;r++){
           sum=arr[l]+arr[r];
           maxSum=Math.max(sum,maxSum);
           l++;
       }
        
        return maxSum;
    }
}