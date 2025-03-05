class Solution {
    public long coloredCells(int n) {
        long count = 1;
        n--;
        while (n > 0) {
            count += n * 4;
            n--;
        }
        return count;
    }
}