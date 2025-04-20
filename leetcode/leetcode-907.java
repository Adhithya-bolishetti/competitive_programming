class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = (int)1e9 + 7;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                int min = arr[i];
                for(int k=i;k<=j;k++) {
                    min = Math.min(min,arr[k]);
                }
                sum = (sum + min) % MOD;
            }
        }
        return (int)sum;
    }
}