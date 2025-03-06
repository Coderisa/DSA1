class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap <Integer,Integer>mp=new HashMap<>();
        int c=0;
        for(int i:nums){
            if (mp.containsKey(i-k))
              c+=mp.get(i-k);
            if (mp.containsKey(i+k))
              c+=mp.get(i+k);
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        return c;
    }
}