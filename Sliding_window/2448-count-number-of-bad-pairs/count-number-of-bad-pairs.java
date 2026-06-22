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