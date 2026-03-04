import java.util.*;

class Solution {
    
    private boolean isValid(int[] nums, int midMax, int n) {
        // Convert to long array to avoid overflow
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > midMax) {
                return false;
            }
            
            long buffer = midMax - arr[i];
            arr[i + 1] = arr[i + 1] - buffer;
        }

        return arr[n - 1] <= midMax;
    }
    
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        
        int maxL = 0;
        int maxR = Arrays.stream(nums).max().getAsInt();
        
        int result = maxR;
        
        while (maxL <= maxR) {
            int midMax = maxL + (maxR - maxL) / 2;
            
            if (isValid(nums, midMax, n)) {
                result = midMax;
                maxR = midMax - 1;
            } else {
                maxL = midMax + 1;
            }
        }
        
        return result;
    }
}
