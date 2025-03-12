class Solution {
    public int maximumCount(int[] nums) {
        // Calculate the count of negative numbers in the array
        int lastnegIndex = lastNegative(nums) + 1; 
        
        // Calculate the count of positive numbers in the array
        int firtposIndex = nums.length - firstPositive(nums);
        
        // Return the maximum count between negative and positive numbers
        return Math.max(lastnegIndex, firtposIndex);
    }

    // Method to find the last occurrence of a negative number in the array
    public int lastNegative(int[] nums) {
        int start = 0;          // Start of the search range
        int end = nums.length - 1; // End of the search range
        int ans = -1;           // Variable to store the index of the last negative number

        while (start <= end) {
            int mid = (start + end) / 2; // Find the middle index
            if (nums[mid] < 0) {         // If the middle element is negative
                ans = mid;               // Update the index of the last negative number
                start = mid + 1;         // Move the search range to the right
            } else {                     // If the middle element is non-negative
                end = mid - 1;           // Move the search range to the left
            }
        }

        return ans; // Return the index of the last negative number, or -1 if not found
    }

    // Method to find the first occurrence of a positive number in the array
    public int firstPositive(int[] nums) {
        int start = 0;          // Start of the search range
        int end = nums.length - 1; // End of the search range
        int ans = nums.length;  // Variable to store the index of the first positive number
      //very imp ans ko -1 mt rakhna
        while (start <= end) {
            int mid = (start + end) / 2; // Find the middle index
            if (nums[mid] > 0) {         // If the middle element is positive
                ans = mid;               // Update the index of the first positive number
                end = mid - 1;           // Move the search range to the left
            } else {                     // If the middle element is non-positive
                start = mid + 1;         // Move the search range to the right
            }
        }

        return ans; // Return the index of the first positive number, or nums.length if not found
    }
}

/* -BRUTE FORCE
 int max=0; int i=0,p=0,n=0;
  while(i<nums.length) {
     if (nums[i]>0) p++;
      if (nums[i]<0) n++;
       } return Math.max(p,n);
        } 
        } */