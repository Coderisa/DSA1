class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] row : grid) {
            Arrays.fill(row, n); // initialize with max possible arm length
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0; // mark mines
        }

        // DP pass: compute arm lengths in all 4 directions
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0, up = 0, down = 0;
            for (int j = 0, k = n - 1; j < n; j++, k--) {
                // Left
                left = (grid[i][j] == 0) ? 0 : left + 1;
                grid[i][j] = Math.min(grid[i][j], left);

                // Right
                right = (grid[i][k] == 0) ? 0 : right + 1;
                grid[i][k] = Math.min(grid[i][k], right);

                // Up
                up = (grid[j][i] == 0) ? 0 : up + 1;
                grid[j][i] = Math.min(grid[j][i], up);

                // Down
                down = (grid[k][i] == 0) ? 0 : down + 1;
                grid[k][i] = Math.min(grid[k][i], down);
            }
        }

        int maxOrder = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxOrder = Math.max(maxOrder, val);
            }
        }

        return maxOrder;
    }
}
