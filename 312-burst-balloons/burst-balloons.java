class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            padded[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // length is the distance between left and right
        for (int length = 2; length <= n + 1; length++) {
            for (int left = 0; left <= n + 1 - length; left++) {
                int right = left + length;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][i] + dp[i][right] + padded[left] * padded[i] * padded[right]);
                }
            }
        }

        return dp[0][n + 1];
    }
}
