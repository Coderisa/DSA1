class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // Try all possible lengths of the representation from max down to 2
        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long k = searchBase(num, m);
            if (k != -1) {
                return Long.toString(k);
            }
        }

        // If no base found, return num - 1 (which always gives "11")
        return Long.toString(num - 1);
    }

    private long searchBase(long num, int m) {
        long left = 2, right = (long)Math.pow(num, 1.0 / (m - 1)) + 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 1, curr = 1;

            for (int i = 1; i < m; i++) {
                curr *= mid;
                if (curr > num) {
                    sum = num + 1; // overflow guard
                    break;
                }
                sum += curr;
            }

            if (sum == num) return mid;
            else if (sum < num) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
