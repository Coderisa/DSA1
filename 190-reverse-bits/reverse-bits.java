class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit
            int bit = n & 1;
            // Shift result left and add the extracted bit
            result = (result << 1) | bit;
            // Shift input right to process the next bit
            n >>>= 1; // Use unsigned shift to avoid sign extension
        }

        return result;
    }
}
