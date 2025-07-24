// User function Template for Java

class Solution {
    public int[] dupLastIndex(int[] arr) {
        // Complete the function
        int index = -1;
        int element = -1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] == arr[i]) {
                index = i;
                element = arr[i];
            }
        }
        
        return new int[]{index, element};
    }
}
// Time complexity : O(n)
// Space complexity : O(1)