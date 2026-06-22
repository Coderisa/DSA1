class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = mp.getOrDefault(diff, 0);
            
            result += (totalPairsTillIndex - goodPairs);
            
            mp.put(diff, goodPairs + 1);
        }
        
        return result;
    }
}
/*
//Approach-1 (Brute Force)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i != nums[j] - nums[i]) {
                    result++;
                }
            }
        }
        
        return result;
    }
}


//Approach-2 (Using hashmap)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for (int j = 1; j < n; j++) {
            int countOfNumsj = map.getOrDefault(nums[j], 0);
            int totalNumsBeforej = j;
            int badPairs = totalNumsBeforej - countOfNumsj;
            result += badPairs;
            
            map.put(nums[j], countOfNumsj + 1);
        }

        return result;
    }
}

//Approach-3 (Using hashmap)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = mp.getOrDefault(diff, 0);
            
            result += (totalPairsTillIndex - goodPairs);
            
            mp.put(diff, goodPairs + 1);
        }
        
        return result;
    }
}


class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        
        long total = nums.length;          // total elements
        long c = 0;                        // will be 2 * badPairs
        for (int j = 0; j < nums.length; j++) {
            int s = nums[j] - j;
            c += total - mp.get(s);        // n - freq(key)
        }
        return c / 2;                      // divide by 2!
    }
}
/*
   class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        
        long n = nums.length;
        long totalPairs = n * (n - 1) / 2;
        long goodPairs = 0;
        for (int freq : mp.values()) {
            goodPairs += (long) freq * (freq - 1) / 2;
        }
        return totalPairs - goodPairs;
    }
}
*/