class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
    }

    private int backtrack(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) return 1; // Found a valid solution

        int count = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // index for main diagonal
            int d2 = row + col;     // index for anti-diagonal

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                cols[col] = diag1[d1] = diag2[d2] = true;
                count += backtrack(row + 1, cols, diag1, diag2, n);
                cols[col] = diag1[d1] = diag2[d2] = false; // backtrack
            }
        }
        return count;
    }
}
