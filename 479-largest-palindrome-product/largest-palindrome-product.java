class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);

        for (int left = upper; left >= lower; left--) {
            long palindrome = createPalindrome(left);
            for (long i = upper; i >= lower; i--) {
                if (palindrome / i > upper) break;
                if (palindrome % i == 0) {
                    return (int)(palindrome % 1337);
                }
            }
        }

        return 0;
    }

    private long createPalindrome(int half) {
        String s = Integer.toString(half);
        StringBuilder sb = new StringBuilder(s).reverse();
        return Long.parseLong(s + sb.toString());
    }
}
