class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int len = group.length;

        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= len; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];

            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    // Don't take this crime
                    dp[i][j][k] = dp[i - 1][j][k];

                    // Take this crime if enough members
                    if (j >= g) {
                        int newProfit = Math.min(minProfit, k - p + p); // ensure cap at minProfit
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - g][Math.max(0, k - p)]) % MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= n; j++) {
            result = (result + dp[len][j][minProfit]) % MOD;
        }

        return result;
    }
}
