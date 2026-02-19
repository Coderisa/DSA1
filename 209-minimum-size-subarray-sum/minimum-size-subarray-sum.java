class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int max=Integer.MAX_VALUE;
        int i=0 , j=0, s=0,  flag =1;
        while(j < nums.length){
            s+=nums[j];
            while(s >= target && i<=j){
                max=Math.min(max , j -i +1);
                
                s-= nums[i];
                i++;
               flag =0;
            }
            j++;
        }
        if (flag==1) return 0;
        else 
        return max;
    }
}