import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map<remainder, earliest index where this remainder appeared>
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // virtual prefix sum 0 before start
        
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            int remainder;
            if (k == 0) {
                // When k = 0, we need subarray sum exactly 0
                // So we store the running sum itself as the "remainder"
                remainder = runningSum;
            } else {
                remainder = runningSum % k;
                // Ensure non-negative remainder (Java's % can be negative)
                if (remainder < 0) remainder += k;
            }
            
            if (remainderMap.containsKey(remainder)) {
                int prevIndex = remainderMap.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }
}