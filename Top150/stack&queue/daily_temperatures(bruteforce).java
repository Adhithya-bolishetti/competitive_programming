class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)