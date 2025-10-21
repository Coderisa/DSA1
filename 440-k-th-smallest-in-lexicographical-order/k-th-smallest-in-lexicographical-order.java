class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // we start from 1, so we need k-1 steps

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // Move to next sibling
                curr++;
                k -= steps;
            } else {
                // Move to next child
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // Count how many numbers are between prefix1 and prefix2 in [1, n]
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1L, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
