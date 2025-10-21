class Solution {
    private static final int[][] DIRS = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] memo = new Double[k + 1][n][n];
        return dfs(n, k, row, column, memo);
    }

    private double dfs(int n, int k, int row, int col, Double[][][] memo) {
        if (row < 0 || row >= n || col < 0 || col >= n) return 0.0;
        if (k == 0) return 1.0;
        if (memo[k][row][col] != null) return memo[k][row][col];

        double prob = 0.0;
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            prob += dfs(n, k - 1, newRow, newCol, memo) / 8.0;
        }

        memo[k][row][col] = prob;
        return prob;
    }
}
