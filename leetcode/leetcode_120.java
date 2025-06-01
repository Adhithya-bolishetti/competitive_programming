class Solution {
    public int minimumPathSum(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        int down = triangle.get(i).get(j) + minimumPathSum(triangle, i+1, j);
        int diagonal = triangle.get(i).get(j) + minimumPathSum(triangle, i+1, j+1);
        return Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumPathSum(triangle, 0, 0);
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)