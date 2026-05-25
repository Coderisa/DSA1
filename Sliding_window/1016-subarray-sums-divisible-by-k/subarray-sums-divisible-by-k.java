class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum=0, c=0;
        mp.put(0,1);

        for(int i=0;i<nums.length;i++){
          sum+=nums[i];
          int rem=sum % k;
          if( rem <0) rem =rem+k;
          if(mp.containsKey(rem)){
           c+=mp.get(rem);
          }
          mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return c;
    }
}
//proof for  if( rem <0) rem =rem+k;
 //https://docs.google.com/document/d/1yemgZbDoE9ZWIS1MM7Cks4AFpv8Db4a8HD6Rc-Ekz34/edit?tab=t.0
