class Solution {
    public int maximumCount(int[] nums) {
        int firstPos = nums.length - firstPositive(nums); // Count of positive numbers
        int lastN = lastNegative(nums) + 1;              // Count of negative numbers

        // Handle edge cases
        if (firstPositive(nums) == -1) firstPos = 0; // No positive numbers
        if (lastNegative(nums) == -1) lastN = 0;    // No negative numbers

        return Math.max(firstPos, lastN);
    }

    int lastNegative(int[] nums) {
        int s = 0, e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] < 0) {
                ans = mid;
                s = mid + 1; // Search the right part
            } else {
                e = mid - 1; // Search the left part
            }
        }
        return ans;
    }

    int firstPositive(int[] nums) {
        int s = 0, e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] > 0) {
                ans = mid;
                e = mid - 1; // Search the left part
            } else {
                s = mid + 1; // Search the right part
            }
        }
        return ans;
    }
}
