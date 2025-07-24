// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int temp = arr[arr.length-1];
        
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            arr[i] = temp;
            temp = curr;
        }
    }
}
// Time complexity : O(n)