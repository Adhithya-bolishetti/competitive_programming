class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int row=0;row<n;row++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0;i<n;i++) {
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for(int col=0;col<n;col++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0;i<n;i++) {
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        int m = n / 3;
        for (int square = 0; square < n; square++) {
            Set seen = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    int row = (square / m) * m + i;
                    int col = (square % m) * m + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
// Time Complexity: O(N^2)
// Space Complexity: O(N)