class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = num.substring(0, i);
                String b = num.substring(i, j);
                
                // Skip if a or b has leading zeros
                if ((a.length() > 1 && a.startsWith("0")) || (b.length() > 1 && b.startsWith("0"))) {
                    continue;
                }
                
                if (isValidSequence(a, b, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidSequence(String a, String b, String remaining) {
        while (!remaining.isEmpty()) {
            String sum = addStrings(a, b);
            if (!remaining.startsWith(sum)) {
                return false;
            }
            remaining = remaining.substring(sum.length());
            a = b;
            b = sum;
        }
        return true;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}
