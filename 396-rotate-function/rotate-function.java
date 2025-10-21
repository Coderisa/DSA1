class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, F = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += (long) i * nums[i];
        }

        long max = F;

        for (int k = 1; k < n; k++) {
            F = F + sum - (long) n * nums[n - k];
            max = Math.max(max, F);
        }

        return (int) max;
    }
}
