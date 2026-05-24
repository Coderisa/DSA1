import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);          // virtual prefix sum 0 before start
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int remainder;
            if (k == 0) {
                // For k = 0, we need subarray sum exactly 0
                // Use the running sum itself as the "remainder"
                remainder = sum;
            } else {
                remainder = sum % k;
                // Ensure non‑negative remainder (Java's % can be negative for negative numbers,
                // but nums[i] >= 0 per constraints, so this is defensive)
                if (remainder < 0) remainder += k;
            }
            
            if (mp.containsKey(remainder)) {
                int prevIndex = mp.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                mp.put(remainder, i);
            }
        }
        return false;
    }
}