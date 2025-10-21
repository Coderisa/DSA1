class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = String.valueOf(n);
        int len = num.length();
        int[] dp = new int[len + 1];
        dp[len] = 1; // base case: one way to build nothing

        // Count numbers with same length as n
        for (int i = len - 1; i >= 0; i--) {
            int currDigit = num.charAt(i) - '0';
            for (String d : digits) {
                int digit = Integer.parseInt(d);
                if (digit < currDigit) {
                    dp[i] += Math.pow(digits.length, len - i - 1);
                } else if (digit == currDigit) {
                    dp[i] += dp[i + 1];
                }
            }
        }

        // Count numbers with fewer digits than n
        int total = 0;
        for (int i = 1; i < len; i++) {
            total += Math.pow(digits.length, i);
        }

        return total + dp[0];
    }
}
