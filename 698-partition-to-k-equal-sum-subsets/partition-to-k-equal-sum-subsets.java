class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % k != 0) return false;

        int target = totalSum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) return false;

        boolean[] visited = new boolean[n];
        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currSum, int target) {
        if (k == 0) return true;
        if (currSum == target) {
            return backtrack(nums, visited, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > target) continue;

            visited[i] = true;
            if (backtrack(nums, visited, k, i + 1, currSum + nums[i], target)) return true;
            visited[i] = false;
        }

        return false;
    }
}
