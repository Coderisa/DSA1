class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //subarray sum == gaol wale subarary ki count
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
           prefix[i]=nums[i]+prefix[i-1];
    
     HashMap<Integer,Integer>mp=new HashMap<>();
    mp.put(0,1);  //for subarrays  which start from index 0
    int c=0;
    for(int i=0;i<nums.length;i++){
        if(mp.containsKey(prefix[i]-goal))
          c+=mp.get(prefix[i]-goal);
        mp.put(prefix[i],mp.getOrDefault(prefix[i] , 0)+1);
    }
    return c;
}
}