class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i=n-2;i>=0;i--) {
            int j = i + 1;
            while(j < n && temperatures[j] <= temperatures[i]) {
                if(res[j] > 0) {
                    j += res[j];
                } else {
                    j = n;
                }
            }

            if(j < n) {
                res[i] = j - i;
            }
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)