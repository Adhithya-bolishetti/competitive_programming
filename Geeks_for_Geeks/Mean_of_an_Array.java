// User function Template for Java

class Solution {
    public static int findMean(int[] arr) {
        // code here
        int n = arr.length;
        int sum = 0;
        
        for(int i=0; i<n; i++) sum+=arr[i];
        
        return sum/n;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)