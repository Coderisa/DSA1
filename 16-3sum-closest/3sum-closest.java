import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int closest = nums[0] + nums[1] + nums[2]; // Initialize with first triplet

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                // Update closest if current sum is closer to target
                if (Math.abs(currSum - target) < Math.abs(closest - target)) {
                    closest = currSum;
                }

                // Move pointers based on comparison
                if (currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }
}
