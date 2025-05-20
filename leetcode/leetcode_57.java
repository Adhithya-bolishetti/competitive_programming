class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(Arrays.asList(newInterval[0],newInterval[1]));
        while(i < n) {
            list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            i++;
        }
        int[][] res = new int[list.size()][2];
        for(int j=0; j< res.length; j++) {
            for(int k=0; k<2; k++) {
                res[j][k] = list.get(j).get(k);
            }
        }
        return res;
    }
}
//Time complexity : O(n)
//Space complexity : O(n)