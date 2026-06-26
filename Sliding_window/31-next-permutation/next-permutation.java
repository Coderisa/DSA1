class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;   // start from the last element
        
        // Find the first index i (from right) such that nums[i] > nums[i-1]
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        
        // If i != 0, we found a pivot at (i-1)
        if (i != 0) {
            int index = i;
            // Find the smallest element to the right of pivot that is larger than pivot
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }
            // Swap pivot with that element
            swap(nums, i - 1, index);
        }
        
        // Reverse the suffix starting at index i
        reverse(nums, i);
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}