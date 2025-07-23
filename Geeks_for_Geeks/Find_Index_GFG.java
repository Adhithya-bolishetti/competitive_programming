// User function Template for Java

class Solution {
    // Function to find starting and end index
    static int[] findIndex(int arr[], int key) {
        // code here.
        int l = -1;
        int r = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(l == -1 && arr[i] == key) {
                l = i;
                r = i;
            }
            if(r != -1 && arr[i] == key) {
                r = i;
            }
        }
        
        return new int[]{l,r};
    }
}
// Time complexity : O(n)
// Space complexity : O(1)