class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = currMax;
            int tempMin = currMin;

            currMax = Math.max(nums[i], Math.max(tempMax * nums[i], tempMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(tempMax * nums[i], tempMin * nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
