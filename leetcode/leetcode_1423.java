class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;

        for(int i=0;i<k;i++) {
            rsum += cardPoints[i];
        }

        int maxSum = rsum;
        int rindex = cardPoints.length-1;

        for(int i=k-1;i>=0;i--) {
            rsum -= cardPoints[i];
            lsum += cardPoints[rindex];
            maxSum = Math.max(maxSum,rsum+lsum);
            rindex--;
        }
        return maxSum;
    }
}
//Time complexity : O(k)
//Space complexity : O(1)