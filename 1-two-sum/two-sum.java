class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=nums.length;
        HashMap <Integer,Integer> mp=new HashMap<>();
       
        for( int i=0;i<nums.length;i++){
           int r=target-nums[i];//search for r in nums
           if (mp.containsKey(r) )
            return new int[] {i,mp.get(r)};
            else 
            mp.put(nums[i],i);
        }
         return new int[] {-1,-1};
    }} //we can also use 2 pointers .first sort the array the l and r pointers. if (sum of the values at these ponirts > target) r-- elase l++
    //but as they have asked fot the original indeces to return ans sorting the array we will losos them
        /*
        for(int i=0;i<nums.length-1;i++)
        { 
            for(int j=i+1;j<nums.length;j++)
            {
               if (nums[i]+nums[j]==target)
               {
                return new int[] {i,j};
               }
                
            }
        }
        return new int [] {};
    }
}
    */
