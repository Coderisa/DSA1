class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find the first index i where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        // If all numbers 1..n are present, return n + 1
        return n + 1;
    }
}
