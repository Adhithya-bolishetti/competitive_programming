class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int ans = start ^ goal;
        while(ans != 0) {
            count += ans & 1;
            ans = ans>>1;

        }
        return count;
    }
}