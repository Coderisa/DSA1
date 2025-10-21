class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip empty cells
                if (board[i][j] == '.') continue;

                // Skip cells that are part of a battleship continuing from above or left
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;

                // This is the start of a new battleship
                count++;
            }
        }

        return count;
    }
}
