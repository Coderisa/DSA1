class Solution {
    public int findIntegers(int n) {
        // dp[i] = number of valid binary strings of length i without consecutive ones
        int[] dp = new int[32];
        dp[0] = 1; // empty string
        dp[1] = 2; // "0", "1"

        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 0;
        int prevBit = 0;

        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result += dp[i];
                if (prevBit == 1) {
                    return result; // found consecutive ones
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
        }

        return result + 1; // include n itself if valid
    }
}
