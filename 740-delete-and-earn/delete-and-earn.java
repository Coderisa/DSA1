class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // Apply House Robber DP
        int take = 0, skip = 0;
        for (int i = 0; i <= max; i++) {
            int takeNew = skip + points[i];
            skip = Math.max(skip, take);
            take = takeNew;
        }

        return Math.max(take, skip);
    }
}
