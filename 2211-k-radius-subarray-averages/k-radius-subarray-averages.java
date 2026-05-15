class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int windowSize = 2 * k + 1;
        if (windowSize > n) return ans; // no averages possible

        long sum = 0;
        // initial window sum
        for (int idx = 0; idx < windowSize; idx++) {
            sum += nums[idx];
        }

        int l = 0;
        int r = windowSize - 1;
        int i = k;

        // sliding window using while loop
        while (r < n) {
            ans[i] = (int)(sum / windowSize);

            // move window forward
            sum -= nums[l];
            l++;
            r++;
            i++;

            if (r < n) {
                sum += nums[r];
            }
        }

        return ans;
    }
}
