class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        //if vo num aray mein already exist karta hai then do count ++
        int c=0;
        for(int i : nums){
           if(mp.containsKey(i)) {
           c+=mp.get(i);
           };
           mp.put(i,mp.getOrDefault(i,0)+1);
        }
         return c;  
    }
   
}