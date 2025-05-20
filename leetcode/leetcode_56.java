import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Merge intervals
        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // Overlap: extend current interval
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap: add current and move to next
                merged.add(current);
                current = intervals[i];
            }
        }

        // Don't forget to add the last interval
        merged.add(current);

        // Step 3: Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
//Time complexity : O(nlogn)
//Space complexity : O(n)