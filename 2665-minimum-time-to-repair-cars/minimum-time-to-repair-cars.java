class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1; long result=-1;
        long right = 1L * max(ranks) * cars * cars;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canRepairAll(ranks, cars, mid)) {
                result=mid;
                right = mid-1;  // Try smaller time
            } else {
                left = mid + 1;  // Need more time
            }
        }
        
        return result;
    }
    
    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long totalCars = 0;
        
        for (int rank : ranks) {
            // Maximum cars this mechanic can repair in 'time' minutes
            long carsByThisMechanic = (long) Math.sqrt(time / rank);
            totalCars += carsByThisMechanic;
            
            // Early exit if we already have enough capacity
            if (totalCars >= cars) {
                return true;
            }
        }
        
        return totalCars >= cars;
    }
    
    private int max(int[] arr) {
        int minVal = Integer.MIN_VALUE;
        for (int num : arr) {
            minVal = Math.max(minVal, num);
        }
        return minVal;
    }
}