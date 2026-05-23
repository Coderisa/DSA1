//CodeWithMIK
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer,Integer>mp=new HashMap<>();
        int Prefix[]=new int[nums.length];

        int c=0;
        mp.put(0,1);//Mann lo ki Prefix sum pahle 0 tha for the test cae [1,-1]

        //Prefix array
        if(nums.length>0)
           Prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
           Prefix[i]=Prefix[i-1]+nums[i];

        for(int i=0;i<nums.length;i++){

            if (mp.containsKey(Prefix[i]-k))//outside barcakets are imp
             c+=mp.get(Prefix[i]-k); //[1,-1,0] ;pre[]=[1,0,0];k=0 in hasmap 0 | 2 was there we will add 2 kyoni [1,-1,0]=k && 0 itself =k
             mp.put(Prefix[i],mp.getOrDefault(Prefix[i],0)+1);
        }   
        return c;
    }
}
/* pahle se bina prefix array banaya bhi kaam ho jaye gaa ,Becoz we need Prefix sum at the moment  only
  for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                result += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
*/