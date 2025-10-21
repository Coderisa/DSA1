class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        // Iterate over each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    countOnes++;
                }
            }
            int countZeros = n - countOnes;
            total += countOnes * countZeros;
        }

        return total;
    }
}
