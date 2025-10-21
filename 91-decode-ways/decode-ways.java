class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty string has one way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // First char must not be '0'

        for (int i = 2; i <= n; i++) {
            // One-digit decode (s[i-1])
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two-digit decode (s[i-2]s[i-1])
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
