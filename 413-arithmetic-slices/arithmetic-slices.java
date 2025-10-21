class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int count = 0;
        int curr = 0;

        for (int i = 2; i < nums.length; i++) {
            // Check if the current triplet forms an arithmetic sequence
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;         // Extend the previous sequence
                count += curr;  // Add all new slices ending at i
            } else {
                curr = 0;       // Reset if the sequence breaks
            }
        }

        return count;
    }
}
