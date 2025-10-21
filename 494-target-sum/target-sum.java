class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Check if (target + totalSum) is even and non-negative
        if ((target + totalSum) % 2 != 0 || totalSum < Math.abs(target)) return 0;

        int subsetSum = (target + totalSum) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }
}
