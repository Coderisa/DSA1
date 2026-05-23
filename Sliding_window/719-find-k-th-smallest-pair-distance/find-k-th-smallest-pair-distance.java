import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        
        // Step 2: Define search space for possible distances
        int left = 0;                     // smallest possible distance
        int right = nums[n - 1] - nums[0]; // largest possible distance
        
        // Step 3: Binary search on the answer (distance)
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairsWithDistanceLeq(nums, mid);
            
            if (count < k) {
                // We need a larger distance
                left = mid + 1;
            } else {
                // mid might be the answer, try smaller
                right = mid;
            }
        }
        return left;
    }
    
    // Count how many pairs (i, j) with i < j have nums[j] - nums[i] <= d
    private int countPairsWithDistanceLeq(int[] nums, int d) {
        int n = nums.length;
        int count = 0;
        int right = 0; // right pointer for sliding window
        
        for (int left = 0; left < n; left++) {
            // Move right pointer as far as possible while distance <= d
            while (right + 1 < n && nums[right + 1] - nums[left] <= d) {
                right++;
            }
            // Number of valid pairs with current left: all j from left+1 to right
            count += right - left;
        }
        return count;
    }
    
   
}