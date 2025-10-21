class Solution {
    public int integerReplacement(int n) {
        long num = n; // use long to avoid overflow for Integer.MAX_VALUE
        int steps = 0;

        while (num != 1) {
            if ((num & 1) == 0) {
                num /= 2;
            } else {
                if (num == 3 || (num & 3) == 1) {
                    num--;
                } else {
                    num++;
                }
            }
            steps++;
        }

        return steps;
    }
}
