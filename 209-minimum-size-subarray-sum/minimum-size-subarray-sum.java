class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int max = Integer.MAX_VALUE;
        int i = 0, s = 0;

        for (int j = 0; j < nums.length; j++) {
            s += nums[j];
            while (s >= target) {
                max = Math.min(max, j - i + 1);
                s -= nums[i++];
            }
        }

        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
