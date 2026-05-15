class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        
        long sum = 0;
        int windowSize = 2 * k + 1;
        if (windowSize > nums.length) return ans;
        
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }
        
        int l = 0, r = 2 * k, i = k;
        while (r < nums.length) {
            ans[i] = (int)(sum / windowSize);   // ✅ division before cast
            sum -= nums[l];
            l++;
            r++;
            i++;
            if (r < nums.length) {
                sum += nums[r];
            }
        }
        return ans;
    }
}