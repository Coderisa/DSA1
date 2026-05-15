class Solution {
    public int[] getAverages(int[] nums, int k) {
        
         int []ans = new int[nums.length];
        // initialize with -1
        Arrays.fill(ans, -1);
        
        int l=0,r=2*k;long  sum=0;
       
        if (2*k+1 > nums.length) return ans; // no averages possible

        for(int i =0 ;i< 2*k +1;i++){
            sum+=nums[i];
        }
        int i =k;// k ke pahle wale sab 0 honge
        
        while( r <nums.length ){
           
           ans[i]= (int) (sum/(2*k+1) );
            sum-=nums[l];
           i++;l++;r++;
           if ( r < nums.length) {
            sum+=nums[r];}
        
        }
       
        return ans;
    }
}