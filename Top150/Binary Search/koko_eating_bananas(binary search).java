class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int pile : piles) {
            r = Math.max(r, pile);
        }

        int res = r;
        while(l <= r) {
            int mid = l + (r - l) / 2;

            long totalTime = 0;
            for(int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / mid);
            }

            if(totalTime <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
//Time Complexity: O(n log m) where n is the number of piles and m is the maximum number of bananas in a pile
//Space Complexity: O(1)