class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, zeros = 0, max = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) zeros++;

            // shrink window if more than 1 zero
            while (zeros > 1) {
                if (nums[i] == 0) zeros--;
                i++;
            }

            // length is j - i (because we delete one zero)
            max = Math.max(max, j - i);
        }

        return max;
    }
}




/*class Solution {
    public int longestSubarray(int[] nums) {
        int i=0, j=0,c=0,l=0,max=0,z=0;
        while(j < nums.length){
            if(nums[j] == 0) c++;
            if(c==1) z=j;
            if(c==2){ 
                l= j-(i+1);
                max=Math.max(max, l);
               
                    i= z+1;
                    z=j;
                    c--;
                }
               j++; 
            }
        
        if(c==1){
            l =(j-1)-i;
            max = Math.max(max, l);
        }
        if(c == 0)
            return j-1;
        
        return max;
        }

        }
        */
        
    
