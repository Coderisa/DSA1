class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }
}//both below shoew time limit exceeded
/*class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap <Integer,Integer>mp=new HashMap<>();
        for(int i:nums)
           mp.put(i,mp.getOrDefault(i,0)+1);
        int max=0;   //nums =[]

        for(int i:nums){
            if(!mp.containsKey(i-1)){
              int count=1;

              while(mp.containsKey(i+count)){
                count++;

                mp.put(i,mp.get(i)-1);}
              max=Math.max(max,count);  

        }  
        }
        return max;
    }
}*/


      /*  HashMap <Integer,Boolean>mp=new HashMap<>();
        for(int i:nums)
           mp.put(i,true);
        for(int i:nums){
          if (mp.containsKey(i-1))
              mp.put(i,false);
        }     
        int msp=0;int ml=0;
        for(int i:nums){
          
            if(mp.get(i)==true){
               int tl=1;
               
               while(mp.containsKey(i+tl))
                  tl++;
               if(tl>ml){
               ml=tl;
               msp=i;}   
        }
        }
        return ml;
    }
}*/
