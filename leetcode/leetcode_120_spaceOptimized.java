class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = triangle.get(n-1).get(i);

        for(int i=n-2; i>=0; i--) {
            int[] temp = new int[n];
            for(int j=i; j>=0; j--) {
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j+1];
                temp[j] = Math.min(down, diagonal);
            }
            dp = temp;
        }
        return dp[0];
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)