class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        int[][][] dp = new int[n][n][k + 1];
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                for (int m = 2; m <= k; m++) {
                    dp[i][j][m] = Integer.MAX_VALUE;
                    for (int mid = i; mid < j; mid += k - 1) {
                        if (dp[i][mid][1] == Integer.MAX_VALUE || dp[mid + 1][j][m - 1] == Integer.MAX_VALUE) continue;
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][mid][1] + dp[mid + 1][j][m - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j][k] + prefix[j + 1] - prefix[i];
            }
        }

        return dp[0][n - 1][1];
    }
}
