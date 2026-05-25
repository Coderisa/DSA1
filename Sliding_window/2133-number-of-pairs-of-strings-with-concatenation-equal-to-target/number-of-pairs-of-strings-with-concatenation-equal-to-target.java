//BRUTE FORCE
 /*class Solution {
    public int numOfPairs(String[] nums, String target) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            
            for(int j=0;j<nums.length;j++){
                if(i!=j){
               String m= nums[i]+nums[j];
               if(m.equals(target)) c++; }

            }
        }
        return c;
    }
}
import java.util.*;
*/
//HASHING - O(N)
class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : nums) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String prefix : nums) {
            if (target.startsWith(prefix)) {
                String suffix = target.substring(prefix.length());
                if (freq.containsKey(suffix)) {
                    count += freq.get(suffix);
                    // avoid counting same index twice
                    if (prefix.equals(suffix)) {
                        count--; 
                    }
                }
            }
        }
        return count;
    }
}
