class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
        // Check if l is a valid single element
        
    }
}
/*Intuition
Let's say the element we are looking for is the target. On observation, we notice that if the index of an element is odd, then its previous element at index -1 should be equal to it. Similarly, if the index of the element is even, then the element next to it or at index +1 should be equal to it. When this condition is not met, it means we have encountered the target.

Approach
Check if the index of mid is odd. If it is, then the element at mid - 1) should be equal to the element at mid. If the index is even, then the element at mid + 1 should be equal to the element at mid. If either condition is true, then the pivot has not occurred. In this case, set low = mid + 1.

2)If the above condition is false, it means the target has already occurred, or the current element is the target itself. In this case, set high = mid.

3)Return nums[l]

Complexity
Time complexity:O(log n)

Space complexity:
O(1) notice the array need not be sorted for this approach to work/*
*/
