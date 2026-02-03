class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, left = 0;
        int bottom = rows-1, right = cols-1;

        while(top <= bottom && left <= right) {
            for(int i=left;i<=right;i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                for(int i=right;i>=left;i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                for(int val : result) System.out.print(val +" ");
            }
            if(left <= right) {
                for(int i=bottom;i>=top;i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}