
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int i =0,max=0;
        for(int j=0;j< nums.length;j++){
           if(nums[j] == 0 ){
              i = j+1;
           }
           else
            max=Math.max(max,j-i+1);
            
        }
        return max;
    }
}