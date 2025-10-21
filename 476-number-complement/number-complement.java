class Solution {
    public int findComplement(int num) {
        // Find the number of bits in num
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) | 1;
        }
        // XOR num with mask to flip all bits
        return num ^ mask;
    }
}
