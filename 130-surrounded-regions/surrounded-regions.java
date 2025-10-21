class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark border-connected 'O's
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);
            dfs(board, m - 1, j, m, n);
        }

        // Step 2: Flip and restore
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Restore
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

        board[i][j] = 'T'; // Temporarily mark

        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
