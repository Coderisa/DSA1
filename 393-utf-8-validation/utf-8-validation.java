class Solution {
    public boolean validUtf8(int[] data) {
        int remaining = 0;

        for (int byteVal : data) {
            if (remaining == 0) {
                if ((byteVal >> 7) == 0b0) {
                    remaining = 0; // 1-byte character
                } else if ((byteVal >> 5) == 0b110) {
                    remaining = 1; // 2-byte character
                } else if ((byteVal >> 4) == 0b1110) {
                    remaining = 2; // 3-byte character
                } else if ((byteVal >> 3) == 0b11110) {
                    remaining = 3; // 4-byte character
                } else {
                    return false; // Invalid leading byte
                }
            } else {
                if ((byteVal >> 6) != 0b10) {
                    return false; // Invalid continuation byte
                }
                remaining--;
            }
        }

        return remaining == 0;
    }
}
