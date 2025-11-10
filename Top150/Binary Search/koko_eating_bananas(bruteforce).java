class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;
        while (true) {
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / speed);
            }

            if (totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }
}
// Time Complexity: O(N * M) where N is the number of piles and M is the maximum pile size
// Space Complexity: O(1)