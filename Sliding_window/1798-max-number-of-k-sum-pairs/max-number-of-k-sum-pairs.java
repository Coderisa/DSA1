
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int c=0;
        for(int i=0 ;i< nums.length;i++){
               int rem = k -nums[i];
               if(mp.containsKey(rem)){
                c++;
                if(mp.get(rem)==1) mp.remove(rem);
                else  { mp.put(rem,mp.getOrDefault(rem,0)-1);}
               }
               else
               mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return c;
    }
}