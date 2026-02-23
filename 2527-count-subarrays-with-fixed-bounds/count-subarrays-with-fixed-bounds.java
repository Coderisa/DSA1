class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minPosition = -1;
        int maxPosition = -1;
        int culprit = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                culprit = i;
            }

            if (nums[i] == minK) {
                minPosition = i;
            }

            if (nums[i] == maxK) {
                maxPosition = i;
            }

            int count = Math.min(minPosition, maxPosition) - culprit;

            if (count > 0) {
                ans += count;
            }
        }

        return ans;
    }
}