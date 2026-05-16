class Solution {
    public int longestOnes(int[] nums, int k) {
      //  problem simly means that k num of 0's are allowed to occur
      int i =0, z =0,max =0;
      for(int j=0;j< nums.length; j++){
        if (nums[j] == 0 ) z++;
        while( z > k){
            if(nums[i] == 0) z--;
            i++;
        }
        max=Math.max(max,j -i +1);
      }
      return max;
    }
}