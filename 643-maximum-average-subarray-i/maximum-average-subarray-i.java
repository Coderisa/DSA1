class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0, max = Double.NEGATIVE_INFINITY; // Initialize max as a very small value
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            if (r - l + 1 == k) { // Window of size k
                double avg = sum / k; // Correct divisor here (k, not 4.0)
                max = Math.max(max, avg); // Update max
                sum -= nums[l]; // Remove the leftmost element
                l++;
            }
            r++;
        }
        return max; // Return the maximum average
    }
}
/*
class Solution {
     public double findMaxAverage(int[] nums, int k) { 
        double sum=0.0,max=0.0,avg=0.0;
         int l=0,r=0;
          while(r<nums.length){ 
            sum+=nums[r];
             if(r-l+1 ==k){
                 avg=sum/4.0; 
                 max=Math.max(max,avg);
                  sum=sum-nums[l]; l++;
                   } r++; 
                   }
                    return avg;
                     } }

*/