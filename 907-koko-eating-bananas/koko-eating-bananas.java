class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find maximum pile size
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, h, mid)) {
                right = mid;  // Try smaller speed
            } else {
                left = mid + 1;  // Need faster speed
            }
        }
        
        return left;
    }
    
    private boolean canFinish(int[] piles, int h, int speed) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            // Calculate hours for this pile
            // Equivalent to Math.ceil(pile / speed)
            hoursNeeded += (pile + speed - 1) / speed;
            
            // Early exit if already exceeds h
            if (hoursNeeded > h) {
                return false;
            }
        }
        return hoursNeeded <= h;
    }
}