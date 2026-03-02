class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
     long  r  = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        while( l < r){
            long mid = l+(r - l)/2;
             if (possible(time, mid, totalTrips)) {
                r = mid;
            } else {
                l = mid + 1;
            }
            
        } return l;
    }

    private boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        
        for (int t : time) {
            actualTrips += givenTime / t;
            if (actualTrips >= totalTrips) {
                return true;  // Early exit if we already have enough trips
            }
        }
        
        return actualTrips >= totalTrips;
    }

}