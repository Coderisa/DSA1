
class Solution {
    public int longestSubarray(int[] nums) {
        int dp0 = 0; // longest subarray of 1's ending here with 0 deletions
        int dp1 = 0; // longest subarray of 1's ending here with exactly 1 deletion
        int maxLen = 0;

        for (int x : nums) {
            if (x == 1) {
                dp0++;
                dp1++;
            } else { // x == 0
                // delete this zero → the subarray ending here with 1 deletion
                // becomes the run of 1's before this zero (dp0)
                dp1 = dp0;
                dp0 = 0; // we cannot include a zero without deletion
            }
            maxLen = Math.max(maxLen, dp1);
        }

        // If all elements were 1, maxLen == n, but we must delete one element
        return maxLen == nums.length ? nums.length - 1 : maxLen;
    }
}
/*
//BRUTE FORCE - o(N^2)
class Solution {
    int n;

    private int findMax(int[] nums, int skipIdx) {
        int currLength = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (i == skipIdx) continue;
            if (nums[i] == 1) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0;
            }
        }
        return maxLength;
    }

    public int longestSubarray(int[] nums) {
        n = nums.length;
        int result = 0, countZero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZero++;
                result = Math.max(result, findMax(nums, i));
            }
        }

        if (countZero == 0) return n - 1;
        return result;
    }
}
*/

/* SLIDING WINDOW SOLN -CODEWITHMIK - O(2N)= O(N)
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, zeros = 0, max = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) zeros++;

            // shrink window if more than 1 zero
            while (zeros > 1) {
                if (nums[i] == 0) zeros--;//reduce 0's only when i itself is 0 
                i++;
            }


            // length is j - i (because we delete one zero)
            max = Math.max(max, j - i);
        }

        return max;
    }
}

*/


/* SLIDING WINDOW SOLN -CODEWITHMIK - OPTIMIZED 
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int lastZeroIdx = -1;
        int result = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            result = Math.max(result, j - i);
            j++;
        }
        return result;
    }
}

        */

    
