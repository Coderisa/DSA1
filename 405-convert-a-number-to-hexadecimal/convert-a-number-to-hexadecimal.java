class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Process 32 bits, 4 bits at a time
        while (num != 0 && sb.length() < 8) {
            int hexDigit = num & 0xf; // Get last 4 bits
            sb.append(hexChars[hexDigit]);
            num >>>= 4; // Unsigned right shift
        }

        return sb.reverse().toString();
    }
}
