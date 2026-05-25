class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);int c=0;
        int i=0, j= nums.length-1;
       while(i<j){
        int s=nums[i]+nums[j];
        if(s==k){
            c++;
            i++;j--;
        }
        else if(s > k) j--;
        else i++;
       }
       return c;
    }
}