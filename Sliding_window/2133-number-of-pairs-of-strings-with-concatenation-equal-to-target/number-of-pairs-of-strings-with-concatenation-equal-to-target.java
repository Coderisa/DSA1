import java.util.*;

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
