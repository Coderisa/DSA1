class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // base case: 0 odd numbers seen
        int oddCount = 0, result = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            result += countMap.getOrDefault(oddCount - k, 0);
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}
