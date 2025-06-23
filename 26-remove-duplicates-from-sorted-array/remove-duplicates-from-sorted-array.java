class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;int l=nums.length;
        while(j < l){
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return (i+1);
    }
}
        /*
        if (nums.length == 0) return 0;
        
        int k = 1; // Start k at 1 since the first element is always unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Move unique elements to the front
                k++;
            }
        }
        return k; // k is the number of unique elements
    }
} */



