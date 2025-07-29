class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];

        prefix[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] ^ arr[i];
        }

        int[] ans = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            if(queries[i][0] == 0) ans[i] = prefix[queries[i][1]];
            else ans[i] = prefix[queries[i][0]-1] ^ prefix[queries[i][1]];
        }

        return ans;
    }
}
// Time complexity : O(n + q)
// Space complexity : O(n)