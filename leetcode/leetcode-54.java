class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        int left = 0, right = c - 1;
        int top = 0, bottom = r - 1;
        
        while (top <= bottom && left <= right) {
            // Move left to right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;  // Move boundary down
            
            // Move top to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;  // Move boundary left
            
            // Check if there are still rows left
            if (top <= bottom) {
                // Move right to left
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;  // Move boundary up
            }
            
            // Check if there are still columns left
            if (left <= right) {
                // Move bottom to top
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;  // Move boundary right
            }
        }
        return list;
    }
}