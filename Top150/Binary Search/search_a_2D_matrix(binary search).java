class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if(target > matrix[r][c]) {
                left = mid + 1;
            } else if(target < matrix[r][c]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
// Time Complexity: O(log(m*n))
// Space Complexity: O(1)